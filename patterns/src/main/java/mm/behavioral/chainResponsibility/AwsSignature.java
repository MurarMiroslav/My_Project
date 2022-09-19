package mm.behavioral.chainResponsibility;

import java.util.UUID;

public class AwsSignature implements Credentials {

    @Override
    public String getCredentials(String userId) {
        return UUID.randomUUID().toString();
    }
}

