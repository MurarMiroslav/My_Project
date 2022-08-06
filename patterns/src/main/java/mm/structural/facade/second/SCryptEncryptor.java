package mm.structural.facade.second;

public class SCryptEncryptor implements Encryptor {

	@Override
	public String encrypt(String toEncrypt) {
		return "encrypting " + toEncrypt + "with SCrypt";
	}
}
