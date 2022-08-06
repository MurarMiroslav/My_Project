package mm.structural.facade.second;

public class EncryptionFacade implements Encryptors {

	private final SCryptEncryptor sCryptEncryptor;
	private final BCryptEncryptor bCryptEncryptor;
	private final NoOpEncryptor noOpEncryptor;

	public EncryptionFacade(SCryptEncryptor sCryptEncryptor, BCryptEncryptor bCryptEncryptor, NoOpEncryptor noOpEncryptor) {
		this.sCryptEncryptor = sCryptEncryptor;
		this.bCryptEncryptor = bCryptEncryptor;
		this.noOpEncryptor = noOpEncryptor;
	}

	@Override
	public String encryptWithoutModification(String toEncrypt) {
		return noOpEncryptor.encrypt(toEncrypt);
	}

	@Override
	public String encryptWithBCrypt(String toEncrypt) {
		return bCryptEncryptor.encrypt(toEncrypt);
	}

	@Override
	public String encryptWithSCrypt(String toEncrypt) {
		return sCryptEncryptor.encrypt(toEncrypt);
	}
}
