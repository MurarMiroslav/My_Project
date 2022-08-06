package mm.creational.prototype;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {

		Person john = new Person("John", new Address("London Street", "598"));
		Person johnCopyNotClone = john;
		System.out.println("johnCopyNotClone: " + johnCopyNotClone);


		System.out.println();
		Person jane = (Person) john.clone();
		jane.setName("Jane");

		System.out.println("John: " + john);
		System.out.println("Jane: " + jane);
	}
}
