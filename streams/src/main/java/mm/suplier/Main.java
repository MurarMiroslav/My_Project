package mm.suplier;

import java.util.function.Supplier;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {

		Supplier<Person> personSupplier = () -> new Person("Miro", "Murar", "33");
		Person miroPerson = personSupplier.get();
		System.out.println(miroPerson);

		Person miroPersonAgain = personSupplier.get();
		System.out.println(miroPersonAgain);
	}
}
