package mm.behavioral.chainResponsibility;

public interface AuthenticationHandler {

    boolean authenticate(Credentials credentials);
    boolean supports(Class<?> clazz);
}
