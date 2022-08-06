package mm.creational.prototype;

public class Address implements Cloneable{

	private final String streetName;
	private final String houseNumber;

	public Address(String streetName, String houseNumber) {
		this.streetName = streetName;
		this.houseNumber = houseNumber;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Address(streetName, houseNumber);
	}

//	@Override
//	public String toString() {
//		return "Address{" +
//				"streetName='" + streetName + '\'' +
//				", houseNumber='" + houseNumber + '\'' +
//				'}';
//	}
}
