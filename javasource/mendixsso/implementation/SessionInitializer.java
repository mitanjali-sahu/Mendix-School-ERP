package mendixsso.implementation;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.logging.ILogNode;
import com.mendix.m2ee.api.IMxRuntimeRequest;
import com.mendix.m2ee.api.IMxRuntimeResponse;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.ISession;
import com.mendix.systemwideinterfaces.core.IUser;
import com.nimbusds.oauth2.sdk.token.AccessToken;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponse;
import mendixsso.implementation.error.IncompatibleUserTypeException;
import mendixsso.implementation.error.UnauthorizedUserException;
import mendixsso.implementation.handlers.OpenIDHandler;
import mendixsso.implementation.utils.MendixUtils;
import mendixsso.implementation.utils.OpenIDUtils;
import mendixsso.proxies.ForeignIdentity;
import mendixsso.proxies.Token;
import mendixsso.proxies.TokenType;
import mendixsso.proxies.UserProfile;
import mendixsso.proxies.microflows.Microflows;
import system.proxies.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mendixsso.proxies.constants.Constants.*;
import static mendixsso.proxies.microflows.Microflows.encrypt;

public class SessionInitializer {

    public static final String XASID_COOKIE = "XASID";
    private static final String ORIGIN_COOKIE = "originURI";
    private static final ILogNode LOG = Core.getLogger(getLogNode());
    private static final String XAS_SESSION_ID = Core.getConfiguration().getSessionIdCookieName();

    private static void createSessionForUser(IContext context, IMxRuntimeResponse resp, IMxRuntimeRequest req,
                                             User user, OIDCTokenResponse oidcTokenResponse) throws Exception {

        LOG.info("User " + user.getName() + " authenticated. Starting session..");

        final String sessionId = req.getCookie(XAS_SESSION_ID);

        final IUser iUser = Core.getUser(context, user.getName());
        final ISession session = Core.initializeSession(iUser, sessionId);

        // Used to enable Single Sign Off request (from remote sso *server*); must only sign off user in a particular User Agent / Browser
        final String ua = req.getHeader("User-Agent");
        session.setUserAgent(ua);

        if (oidcTokenResponse != null && oidcTokenResponse.getTokens() != null) {

            final Map<String, Object> customParams = oidcTokenResponse.getCustomParameters();

            if (oidcTokenResponse.getTokens().getAccessToken() != null) {
                final AccessToken accessToken = oidcTokenResponse.getTokens().getAccessToken();
                final int accessTokenExpiry = (int) accessToken.getLifetime();

                createToken(context, session, user, TokenType.ACCESS_TOKEN,
                        accessToken.getValue(),
                        accessTokenExpiry);
            }

            if (oidcTokenResponse.getTokens().getRefreshToken() != null) {
                final Long refreshTokenExpiry = (Long) customParams.getOrDefault("refresh_token_expires_in", getTokenExpiryInSeconds());

                createToken(context, session, user, TokenType.REFRESH_TOKEN,
                        oidcTokenResponse.getTokens().getRefreshToken().getValue(),
                        refreshTokenExpiry.intValue());
            }

            if (oidcTokenResponse.getOIDCTokens().getIDToken() != null) {
                final Long idTokenExpiry = (Long) customParams.getOrDefault("id_token_expires_in", getTokenExpiryInSeconds());

                createToken(context, session, user, TokenType.ID_TOKEN,
                        oidcTokenResponse.getOIDCTokens().getIDToken().getParsedString(),
                        idTokenExpiry.intValue());
            }

        } else {

            // the only way to get here is via DefaultLoginHandler.onAlreadyHasSession(),
            // so we can safely assume that the current session already has tokens

            // so we retrieve all tokens from the old session, ...
            final List<Token> tokens = retrieveTokensForSession(context, sessionId);

            // and migrate them to the newly created one
            for (Token token : tokens) {
                token.setSessionId(session.getId().toString());
                token.commit();
            }

        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Created session, fingerprint: " + OpenIDUtils.getFingerPrint(session));
        }

        writeSessionCookies(resp, session);

    }

    private static void writeSessionCookies(IMxRuntimeResponse resp,
                                            ISession session) {
        resp.addCookie(XAS_SESSION_ID, session.getId().toString(), "/", "", -1, true);
        resp.addCookie(XASID_COOKIE, "0." + Core.getXASId(), "/", "", -1, true);
        resp.addCookie(ORIGIN_COOKIE, "/" + OpenIDHandler.OPENID_CLIENTSERVLET_LOCATION + OpenIDHandler.LOGIN, "/", "", -1, false);
    }

    private static void redirectToIndex(IMxRuntimeRequest req, IMxRuntimeResponse resp, String continuation) {
        resp.setStatus(IMxRuntimeResponse.SEE_OTHER);

        //no continuation provided, use index
        if (continuation == null)
            resp.addHeader("location", OpenIDHandler.INDEX_PAGE);
        else {
            if (continuation.trim().startsWith("javascript:")) {
                throw new IllegalArgumentException("Javascript injection detected!");
            } else if (!continuation.startsWith("http://") && !continuation.startsWith("https://")) {
                resp.addHeader("location", OpenIDUtils.getApplicationUrl(req) + continuation);
            } else {
                resp.addHeader("location", continuation);
            }
        }
    }

    public static User findOrCreateUser(UserProfile userProfile) throws Exception {
        final IContext c = Core.createSystemContext();
        c.startTransaction();
        final String uuid = OpenIDUtils.extractUUID(userProfile.getOpenId());
        try {

            ForeignIdentity foreignIdentity = retrieveForeignIdentity(c, uuid);
            final User user;

            // Existing Foreign Identity
            if (foreignIdentity != null) {
                user = updateUser(c, userProfile, foreignIdentity);
                LOG.debug(String.format("User associated to the foreign identity with UUID %s has been updated.", uuid));
            }

            // New Foreign Identity
            else {
                final User systemUser = retrieveSystemUser(c, userProfile.getOpenId());
                if (systemUser != null) {
                    // Existing legacy user (ACS user)
                    final ForeignIdentity newForeignIdentity = createForeignIdentity(c, systemUser, uuid);
                    user = updateUser(c, userProfile, newForeignIdentity);
                    LOG.debug(String.format("Legacy user has been associated to a new foreign identity with UUID %s.", uuid));
                } else {
                    // Create a new user wih an associated foreign identity
                    user = createUserWithForeignIdentity(c, userProfile, uuid);
                    LOG.debug(String.format("New foreign identity with UUID %s has been created.", uuid));
                }
            }

            c.endTransaction();
            return user;
        } catch (Exception e) {
            LOG.warn("Find or create user for UUID '" + uuid + "' caught exception. Triggering rollback.");
            c.rollbackTransAction();
            throw e;
        }
    }

    private static User createUserWithForeignIdentity(IContext c, UserProfile userProfile, String uuid) throws CoreException {
        final IMendixObject mxNewUser = UserMapper.getInstance().createUser(c, userProfile, uuid);

        final boolean hasAccess = Core.execute(c, "MendixSSO.RetrieveUserRoles", new HashMap<String, Object>() {{
            put("UUID", uuid);
            put("User", mxNewUser);
        }});

        if (hasAccess) {
            final User user = User.initialize(c, mxNewUser);
            user.setPassword(OpenIDUtils.randomStrongPassword(48, 48, 7, 9, 6));
            user.commit();

            createForeignIdentity(c, user, uuid);
            return user;
        } else {
            throw new UnauthorizedUserException();
        }
    }

    private static ForeignIdentity createForeignIdentity(IContext c, User user, String uuid) throws CoreException {
        final ForeignIdentity foreignIdentity = new ForeignIdentity(c);
        foreignIdentity.setUUID(uuid);
        foreignIdentity.setForeignIdentity_User(user);
        foreignIdentity.commit();

        return foreignIdentity;
    }

    private static User updateUser(IContext c, UserProfile userProfile, ForeignIdentity foreignIdentity) throws CoreException {
        final User user = foreignIdentity.getForeignIdentity_User();

        // because of a change to a new user entity type, it can happen that an old user of an incompatible type is provided
        if (!UserMapper.getInstance().isCompatibleUserType(user)) {
            if (!getConsentToDeleteIncompatibleUsers()) {
                // we do not have consent, in which case we throw an exception that is rendered to the end-user
                throw new IncompatibleUserTypeException(user.getMendixObject().getType());
            } else {
                // we have consent, so delete the old user...
                user.delete();
                // note: the foreign identity is deleted because of delete behavior

                // and create a fresh new user instead
                return createUserWithForeignIdentity(c, userProfile, foreignIdentity.getUUID());
            }
        }

        UserMapper.getInstance().updateUser(c, user, userProfile, foreignIdentity.getUUID());
        retrieveUserRolesAndCommitUser(c, user, foreignIdentity.getUUID());

        return user;
    }

    public static void authorizeUser(User user, String uuid) throws Exception {
        final IContext c = Core.createSystemContext();
        c.startTransaction();
        try {
            LOG.debug("Re-authorizing user for existing session.");
            retrieveUserRolesAndCommitUser(c, user, uuid);

            c.endTransaction();
        } catch (Exception e) {
            LOG.warn(String.format("Authorizing the user with UUID '%s' has failed. Triggering rollback.", uuid));
            c.rollbackTransAction();
            throw e;
        }
    }

    private static void retrieveUserRolesAndCommitUser(IContext c, User user, String uuid) throws CoreException {
        final boolean hasAccess = Microflows.retrieveUserRoles(c, user, uuid);
        if (hasAccess) {
            user.commit();
        } else {
            throw new UnauthorizedUserException();
        }
    }

    public static void createSessionForUserAndRedirect(IContext context, IMxRuntimeRequest req, IMxRuntimeResponse resp,
                                                       User user, String continuation, OIDCTokenResponse oidcTokenResponse) throws Exception {
        SessionInitializer.createSessionForUser(context, resp, req, user, oidcTokenResponse);
        SessionInitializer.redirectToIndex(req, resp, continuation);
    }

    public static ForeignIdentity retrieveForeignIdentity(IContext c, String uuid) {
        return MendixUtils.retrieveSingleObjectFromDatabase(c, ForeignIdentity.class, "//%s[%s = $uuid]",
                new HashMap<String, Object>() {{
                    put("uuid", uuid);
                }},
                ForeignIdentity.entityName,
                ForeignIdentity.MemberNames.UUID.toString()
        );
    }

    private static User retrieveSystemUser(IContext c, String openId) {
        return MendixUtils.retrieveSingleObjectFromDatabase(c, User.class, "//%s[%s = $name]",
                new HashMap<String, Object>() {{
                    put("name", openId);
                }},
                User.entityName,
                User.MemberNames.Name.toString()
        );
    }

    private static void createToken(IContext context, ISession session, User user, TokenType tokenType, String value, int expiresIn) throws CoreException {
        final Token newToken = new Token(context);
        newToken.setTokenType(tokenType);
        newToken.setValue(encrypt(context, value));
        newToken.setExpiresIn(expiresIn);
        newToken.setExpiresAt(new Date(System.currentTimeMillis() + expiresIn * 1000L));
        newToken.setSessionId(session.getId().toString());
        newToken.setToken_User(user);
        newToken.commit();
    }

    private static List<Token> retrieveTokensForSession(IContext context, String sessionId) {
        return MendixUtils.retrieveFromDatabase(context, Token.class,
                "//%s[%s = $sessionId]",
                new HashMap<String, Object>() {{
                    put("sessionId", sessionId);
                }},
                Token.entityName,
                Token.MemberNames.SessionId.toString()
        );
    }

}
