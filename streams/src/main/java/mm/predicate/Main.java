package mm.predicate;

import java.util.function.Predicate;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {

		Person miroPerson = new Person("Miro", "Murar", "33");
//		Person miroPerson = new Person("Miro", "Murar", "29");
		Predicate<Person> predicatePerson = person -> Integer.parseInt(person.getAge()) > 30;
		boolean resultPredicate = predicatePerson.test(miroPerson);

		System.out.println("resultPredicate: " + resultPredicate);
	}
}
