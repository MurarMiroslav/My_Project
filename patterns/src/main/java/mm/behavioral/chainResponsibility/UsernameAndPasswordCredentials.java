package mm.behavioral.chainResponsibility;

public class UsernameAndPasswordCredentials implements Credentials {

    @Override
    public String getCredentials(String userId) {
        return "Miroslav: Mirko123";
    }
}
