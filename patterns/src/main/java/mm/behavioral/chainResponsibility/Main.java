package mm.behavioral.chainResponsibility;

public class Main {

    public static void main(String[] args) {

        final AuthenticationHandler authenticationHandlerAws = new AwsAuthenticationHandler();
        final AuthenticationHandler authenticationHandlerBearer = new BearerTokenAuthenticationHandler();
        final AuthenticationHandler authenticationHandlerUnP = new UsernameAndPasswordAuthenticationHandler();

        final ChainAuthenticationElement lastElement = new ChainAuthenticationElement(authenticationHandlerAws);
        final ChainAuthenticationElement middleElement = new ChainAuthenticationElement(authenticationHandlerBearer, lastElement);
        final ChainAuthenticationElement firstElement = new ChainAuthenticationElement(authenticationHandlerUnP, middleElement);

        firstElement.authenticate(new AwsSignature());
        firstElement.authenticate(new UsernameAndPasswordCredentials());
        firstElement.authenticate(new BearerToken());

        // possible output: INFO pl.sdacademy.cor.ChainAuthenticationElement - Authentication using handler BearerTokenAuthenticationHandler
    }
}
