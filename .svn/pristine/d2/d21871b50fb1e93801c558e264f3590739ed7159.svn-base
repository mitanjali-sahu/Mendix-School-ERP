package mendixsso.implementation.handlers;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.externalinterface.connector.RequestHandler;
import com.mendix.logging.ILogNode;
import com.mendix.m2ee.api.IMxRuntimeRequest;
import com.mendix.m2ee.api.IMxRuntimeResponse;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.ISession;
import com.mendix.systemwideinterfaces.core.IUser;
import com.nimbusds.jwt.JWT;
import com.nimbusds.oauth2.sdk.*;
import com.nimbusds.oauth2.sdk.auth.ClientAuthentication;
import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;
import com.nimbusds.oauth2.sdk.id.State;
import com.nimbusds.openid.connect.sdk.*;
import mendixsso.implementation.SessionInitializer;
import mendixsso.implementation.UserMapper;
import mendixsso.implementation.error.IncompatibleUserTypeException;
import mendixsso.implementation.oidp.IdentityProviderMetaData;
import mendixsso.implementation.oidp.IdentityProviderMetaDataCache;
import mendixsso.implementation.utils.*;
import mendixsso.proxies.AuthRequest;
import mendixsso.proxies.ForeignIdentity;
import mendixsso.proxies.UserProfile;
import mendixsso.proxies.constants.Constants;
import system.proxies.User;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static mendixsso.implementation.utils.OpenIDUtils.extractUUID;
import static mendixsso.implementation.utils.OpenIDUtils.getFingerPrint;

public class OpenIDHandler extends RequestHandler {

    public static final String OPENID_CLIENTSERVLET_LOCATION = "openid/";
    public static final String INDEX_PAGE = Constants.getIndexPage();
    public static final String LOGIN = "login";
    public static final String CALLBACK = "callback";
    private static final String LOGOFF = "logoff";
    private static final String FORCE_LOGOFF = "force_logoff";
    private static final String OPENID_PROVIDER = Constants.getOpenIdConnectProvider();
    private static final boolean SSO_ENABLED = Constants.getSSOEnabled();
    private static final boolean SINGLESIGNOFF_ENABLED = true;
    private static final ILogNode LOG = Core.getLogger(Constants.getLogNode());
    private static final ILoginHandler loginHandler = new DefaultLoginHandler();
    private static final String FALLBACK_LOGINPAGE = "/login.html";
    private static final String CONTINUATION_PARAM = "continuation";
    private boolean started = false;

    public OpenIDHandler() {
        if (!SSO_ENABLED) {
            LOG.info("NOT starting SSO handlers, disabled by configuration");
        } else {
            reconnectToMxID();
        }
    }

    private static AuthRequest retrieveAuthRequest(final IContext context, final String state) throws RuntimeException {
        return MendixUtils.retrieveSingleObjectFromDatabase(context, AuthRequest.class, "//%s[%s = $state]",
                new HashMap<String, Object>() {{
                    put("state", state);
                }},
                AuthRequest.entityName, AuthRequest.MemberNames.State.name());
    }

    private void reconnectToMxID() {
        LOG.info("Starting OpenId handlers ... OpenIdProvider: " + OPENID_PROVIDER);
        try {
            started = true;
            LOG.info("Starting OpenId handlers ... DONE");

        } catch (Exception e) {
            LOG.error("Failed to discover OpenId service: " + e.getMessage(), e);
        }
    }

    @Override
    public void processRequest(IMxRuntimeRequest req, IMxRuntimeResponse resp, String path) {

        //always force expiration on this handlers!
        resp.addHeader("Expires", "0");

        final IContext context = Core.createSystemContext();

        if (LOG.isDebugEnabled())
            LOG.debug("Incoming request: " + path + " fingerprint: " + getFingerPrint(req));

        if (!SSO_ENABLED) {
            LOG.info("NOT handling SSO request, disabled by configuration, redirecting to login.html");
            redirect(resp, FALLBACK_LOGINPAGE);
            return;
        }

        if (!started) {
            reconnectToMxID();
        }

        if (!started) {
            LOG.error("NOT handling SSO request, could not connect to MxID, redirecting to login.html");
            redirect(resp, FALLBACK_LOGINPAGE);
            return;
        }

        try {
            if (LOGOFF.equalsIgnoreCase(path)) {
                logoff(req, resp); //requesting Single Sign Off (from client)
            } else if (FORCE_LOGOFF.equalsIgnoreCase(path)) {
                forceLogoff(context, req, resp); //requesting Single Sign Off (from server)
            } else if (LOGIN.equalsIgnoreCase(path)) {
                login(req, resp); //requesting authorization
            } else if (CALLBACK.equalsIgnoreCase(path)) {
                callback(req, resp); //redirect from open id provider
            } else {
                ErrorUtils.serveError(req, resp, ErrorUtils.ResponseType.INTERNAL_SERVER_ERROR, "Unsupported request '" + path + "'", true, null);
            }
        } catch (Exception e) {
            ErrorUtils.serveError(req, resp, ErrorUtils.ResponseType.INTERNAL_SERVER_ERROR, "An unexpected exception occurred while handling request " + path, true, e);
        }
    }

    private void callback(IMxRuntimeRequest req, IMxRuntimeResponse resp) throws Exception {
        LOG.debug("Callback from OpenID provider, evaluating..");

        final String requestURL = getFullURL(req.getHttpServletRequest());
        final AuthenticationResponse authResp = AuthenticationResponseParser.parse(new URI(requestURL));
        final State state = authResp.getState();

        final IContext context = Core.createSystemContext();

        // check state, get original request
        final AuthRequest originalRequest = retrieveAuthRequest(context, state.getValue());

        if (originalRequest == null) {
            throw new IllegalStateException("Unexpected OpenID callback unknown state");
        }

        if (authResp instanceof AuthenticationErrorResponse) {
            final ErrorObject error = ((AuthenticationErrorResponse) authResp).getErrorObject();
            throw new IllegalStateException(error.getDescription());
        }

        final AuthenticationSuccessResponse successResponse = (AuthenticationSuccessResponse) authResp;

        final Nonce expectedNonce = new Nonce(originalRequest.getNonce());
        final AuthorizationCode authCode = successResponse.getAuthorizationCode();

        /*
         * When an authorization code (using code or hybrid flow) has been
         * obtained, a token request can made to get the access token and the id
         * token:
         */
        final OIDCTokenResponse idTokenResponse = requestOIDCToken(req, authCode, state);

        final JWT idToken = getAndValidateIDToken(idTokenResponse, expectedNonce);

        final UserProfile userProfile = UserProfileUtils.getUserProfile(context, idToken.getJWTClaimsSet().toJSONObject());
        // We assume that openId cannot be null since that would imply bigger issues higher up in the SSO stack.
        final String uuid = extractUUID(userProfile.getOpenId());
        ForeignIdentityUtils.lockForeignIdentity(uuid);
        try {
            loginHandler.onCompleteLogin(context, userProfile, idTokenResponse, originalRequest.getContinuation(), req, resp);
        } finally {
            ForeignIdentityUtils.unlockForeignIdentity(uuid);
        }
    }

    private String getFullURL(HttpServletRequest request) {
        final StringBuffer requestURL = request.getRequestURL();
        final String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }

    private OIDCTokenResponse requestOIDCToken(IMxRuntimeRequest req, AuthorizationCode authCode, State state) throws Exception {

        final IdentityProviderMetaData discovered = IdentityProviderMetaDataCache.getInstance().getIdentityProviderMetaData();
        final ClientAuthentication clientAuthentication = new ClientSecretBasic(discovered.getClientId(), discovered.getClientSecret());

        final TokenRequest tokenReq = new TokenRequest(discovered.getProviderMetadata().getTokenEndpointURI(),
                clientAuthentication, new AuthorizationCodeGrant(authCode, new URI(OpenIDUtils.getRedirectUri(req))),
                new Scope(OIDCScopeValue.OFFLINE_ACCESS)
        );
        LOG.debug("Sending token request for state " + state.getValue() + " with auth code " + authCode);

        final HTTPResponse tokenHTTPResp = tokenReq.toHTTPRequest().send();

        // Parse and check response
        final TokenResponse tokenResponse = OIDCTokenResponseParser.parse(tokenHTTPResp);

        if (tokenResponse instanceof TokenErrorResponse) {
            final ErrorObject error = ((TokenErrorResponse) tokenResponse).getErrorObject();
            throw new IllegalStateException(error.getDescription());
        }

        return (OIDCTokenResponse) tokenResponse;
    }

    private JWT getAndValidateIDToken(OIDCTokenResponse idTokenResponse, Nonce expectedNonce) {
        final JWT idToken = idTokenResponse.getOIDCTokens().getIDToken();
        try {
            // validate the ID token, see http://connect2id.com/blog/how-to-validate-an-openid-connect-id-token
            IdentityProviderMetaDataCache.getInstance().getIdentityProviderMetaData().getIdTokenValidator().validate(idToken, expectedNonce);
        } catch (Exception e) {
            final ErrorObject errorObject = OAuth2Error.SERVER_ERROR.appendDescription(" " + e.getMessage());
            throw new IllegalStateException(errorObject.getDescription());
        }

        return idToken;
    }

    private void login(IMxRuntimeRequest req, IMxRuntimeResponse resp) throws Exception {
        final String continuation = req.getParameter(CONTINUATION_PARAM);
        detectContinuationJsInjection(continuation);

        final IContext context = Core.createSystemContext();

        //special case 1: already a valid session, do not bother with a new login
        final ISession session = this.getSessionFromRequest(req);
        if (session != null && !session.getUser(context).isAnonymous()) {
            LOG.debug("Existing session detected for non-anonymous user.");

            //Logout old session and initialize new session. This will allow for role changes to take effect.
            final ForeignIdentity foreignIdentity = ForeignIdentityUtils.retrieveForeignIdentity(context, session);
            if (foreignIdentity == null) {
                //If the user was deleted in the mean time, we should trigger a authorize request instead.
                LOG.debug("Could not find foreign identity for existing session, performing authorize request to re-login the user.");
                performAuthorizeRequest(req, resp, context, continuation);
                return;
            }

            ForeignIdentityUtils.lockForeignIdentity(foreignIdentity.getUUID());
            try {
                final User user = foreignIdentity.getForeignIdentity_User();
                if (!UserMapper.getInstance().isCompatibleUserType(user)) {
                    // Because of a change to a new user entity type, it can happen that an old user of an incompatible type is provided
                    throw new IncompatibleUserTypeException(user.getMendixObject().getType());
                }
                loginHandler.onAlreadyHasSession(context, user, foreignIdentity.getUUID(),
                        continuation, req, resp);
            } catch (IncompatibleUserTypeException e) {
                // We forcefully logoff the user in order to re-trigger all login logic which will take care of incompatible user type
                logoff(req, resp);
            } finally {
                ForeignIdentityUtils.unlockForeignIdentity(foreignIdentity.getUUID());
            }
        } else {
            performAuthorizeRequest(req, resp, context, continuation);
        }
    }

    private void performAuthorizeRequest(IMxRuntimeRequest req, IMxRuntimeResponse resp, IContext context, String continuation) throws Exception {
        LOG.debug("Incoming login request, redirecting to OpenID provider");

        final State state = new State();
        LOG.debug("OIDC Login process started for, state: " + state.getValue());

        // Initialize or generate nonce
        final Nonce nonce = new Nonce();

        // Specify scope
        final Scope scope = Scope.parse(Constants.getOpenIdConnectScopes());
        final IdentityProviderMetaData discovered = IdentityProviderMetaDataCache.getInstance().getIdentityProviderMetaData();
        // Compose the request
        final AuthenticationRequest authenticationRequest = new AuthenticationRequest.Builder(
                discovered.getResponseType(),
                scope,
                discovered.getClientId(),
                new URI(OpenIDUtils.getRedirectUri(req))
        )
                .endpointURI(discovered.getProviderMetadata().getAuthorizationEndpointURI())
                .state(state)
                .nonce(nonce)
                .build();

        final URI authReqURI = authenticationRequest.toURI();

        // store in the database
        AuthRequest authReq = new AuthRequest(context);
        authReq.setState(state.getValue());
        authReq.setNonce(nonce.getValue());
        authReq.setContinuation(continuation);
        authReq.commit();

        LOG.debug("Redirecting to " + authReqURI.toString());

        redirect(resp, authReqURI.toString());
    }

    private void forceLogoff(IContext context, IMxRuntimeRequest req, IMxRuntimeResponse resp) throws CoreException {
        if (SINGLESIGNOFF_ENABLED)
            forceSessionLogoff(req, context);
        else
            LOG.warn("Received force_logoff request, but single sign off is not enabled in the configuration!");

        resp.setStatus(IMxRuntimeResponse.OK);
        resp.setContentType("text/plain");
    }

    private void logoff(IMxRuntimeRequest req, IMxRuntimeResponse resp) throws CoreException {
        if (SINGLESIGNOFF_ENABLED) {
            resp.addCookie(getSessionCookieName(), "", "/", "", 0, true);
            resp.addCookie(SessionInitializer.XASID_COOKIE, "", "/", "", 0, true);
            resp.setStatus(IMxRuntimeResponse.SEE_OTHER);
            resp.addHeader("location", OPENID_PROVIDER + "/../" + LOGOFF);
        } else {
            ISession ses = this.getSessionFromRequest(req);
            if (ses != null) {
                Core.logout(ses);
            }
            redirect(resp, INDEX_PAGE);
        }
    }

    private void detectContinuationJsInjection(String url) {
        if (url != null && url.trim().startsWith("javascript:"))
            throw new IllegalArgumentException("Javascript injection detected in parameter '" + CONTINUATION_PARAM + "'");
    }

    private void forceSessionLogoff(IMxRuntimeRequest req, IContext context) throws CoreException {
        final String foreignIdentityUUID = OpenIDUtils.extractUUID(req.getParameter("openid"));
        String fingerprint = req.getParameter("fingerprint");

        String basemsg = String.format("Received logoff request for '%s' with fingerprint '%s'... ",
                foreignIdentityUUID, fingerprint);
        LOG.debug(basemsg);

        final ForeignIdentity foreignIdentity = SessionInitializer.retrieveForeignIdentity(context, foreignIdentityUUID);

        if (foreignIdentity == null) {
            LOG.error(String.format("Foreign Identity not found for UUID: %s while trying to force session logoff",
                    foreignIdentityUUID));
            return;
        }

        List<ISession> sessionsOfThisUser = new ArrayList<>();
        // Core.getActiveSessions() is not deprecated anymore from Mendix version 8.0 and onwards
        for (ISession session : Core.getActiveSessions()) {
            final IUser user = session.getUser(context);
            if (user != null && user.getName() != null
                    && user.getName().equals(foreignIdentity.getForeignIdentity_User().getName())) {
                sessionsOfThisUser.add(session);
            }
        }

        if (sessionsOfThisUser.isEmpty())
            LOG.debug(basemsg + "IGNORING. User has no active sessions");
        else {
            boolean found = false;
            for (ISession session : sessionsOfThisUser) {
                if (getFingerPrint(session).equals(fingerprint)) {
                    Core.logout(session);
                    found = true;
                }
            }

            if (found)
                LOG.info(basemsg + "SUCCESS. Session removed.");
            else
                LOG.warn(basemsg + "FAILED. User has active sessions but none matches the provided fingerprint. ");
        }
    }

    private void redirect(IMxRuntimeResponse resp, String url) {
        resp.setStatus(IMxRuntimeResponse.SEE_OTHER);
        resp.addHeader("location", url);
    }
}
