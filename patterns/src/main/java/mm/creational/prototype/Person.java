package mm.creational.prototype;

import lombok.Setter;

@Setter
public class Person implements Cloneable {

	private String name;
	private Address address;

	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Person(name, (Address) address.clone());
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", address=" + address +
				'}';
	}
}
