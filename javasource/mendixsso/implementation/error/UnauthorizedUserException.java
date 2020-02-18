package mendixsso.implementation.error;

public class UnauthorizedUserException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Your account has not been authorized to use this application.";
    }
}
