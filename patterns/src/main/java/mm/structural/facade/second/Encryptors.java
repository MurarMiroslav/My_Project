package mm.structural.facade.second;

public interface Encryptors {

	String encryptWithoutModification(final String toEncrypt);
	String encryptWithBCrypt(final String toEncrypt);
	String encryptWithSCrypt(final String toEncrypt);

}
