package mendixsso.implementation.handlers;

import com.mendix.m2ee.api.IMxRuntimeRequest;
import com.mendix.m2ee.api.IMxRuntimeResponse;
import com.mendix.systemwideinterfaces.core.IContext;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponse;
import mendixsso.implementation.SessionInitializer;
import mendixsso.implementation.error.IncompatibleUserTypeException;
import mendixsso.implementation.error.UnauthorizedUserException;
import mendixsso.implementation.utils.ErrorUtils;
import mendixsso.proxies.UserProfile;
import system.proxies.User;


public class DefaultLoginHandler implements ILoginHandler {

    @Override
    public void onCompleteLogin(IContext context, UserProfile userProfile, OIDCTokenResponse oidcTokenResponse, String continuation, IMxRuntimeRequest req, IMxRuntimeResponse resp) {
        final User user;
        try {
            user = SessionInitializer.findOrCreateUser(userProfile);
        } catch (UnauthorizedUserException e) {
            ErrorUtils.serveError(req, resp, ErrorUtils.ResponseType.UNAUTHORIZED, e.getMessage(), false, null);
            return;
        } catch (IncompatibleUserTypeException e) {
            ErrorUtils.serveError(req, resp, ErrorUtils.ResponseType.INCOMPATIBLE_USER_TYPE_ERROR, e.getMessage(), false, e);
            return;
        } catch (Exception e) {
            ErrorUtils.serveError(req, resp, ErrorUtils.ResponseType.INTERNAL_SERVER_ERROR, "We failed to register your account in this app. Please try again later or contact the administrator of this app.", false, e);
            return;
        }

        try {
            SessionInitializer.createSessionForUserAndRedirect(context, req, resp, user, continuation, oidcTokenResponse);
        } catch (Exception e) {
            ErrorUtils.serveError(req, resp, ErrorUtils.ResponseType.INTERNAL_SERVER_ERROR, "Failed to initialize session", false, e);
        }
    }

    @Override
    public void onAlreadyHasSession(IContext context, User user, String uuid, String continuation, IMxRuntimeRequest req, IMxRuntimeResponse resp) {
        try {
            SessionInitializer.authorizeUser(user, uuid);
        } catch (UnauthorizedUserException e) {
            ErrorUtils.serveError(req, resp, ErrorUtils.ResponseType.UNAUTHORIZED, "Your account has not been authorized to use this application.", false, null);
            return;
        } catch (Exception e) {
            ErrorUtils.serveError(req, resp, ErrorUtils.ResponseType.INTERNAL_SERVER_ERROR, "We failed to register your account in this app. Please try again later or contact the administrator of this app.", false, e);
            return;
        }

        try {
            SessionInitializer.createSessionForUserAndRedirect(context, req, resp, user, continuation, null);
        } catch (Exception e) {
            ErrorUtils.serveError(req, resp, ErrorUtils.ResponseType.INTERNAL_SERVER_ERROR, "Failed to initialize session", false, e);
        }
    }

}
