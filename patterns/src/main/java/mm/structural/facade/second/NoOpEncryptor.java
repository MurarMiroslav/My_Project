package mm.structural.facade.second;

public class NoOpEncryptor implements Encryptor {

	@Override
	public String encrypt(String toEncrypt) {
		return toEncrypt;
	}
}
