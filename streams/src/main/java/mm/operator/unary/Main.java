package mm.operator.unary;

import java.util.function.UnaryOperator;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {

		// In this example, the Function<Integer, Integer> which accepts and returns the same type, can be replaced with UnaryOperator<Integer>.
		UnaryOperator<Person> unaryOperator = person -> new Person(person.getName(), "UnarySurname", "UnaryAge");
		Person miroPerson = new Person("Miro", "Murar", "33");

		Person unaryPerson = unaryOperator.apply(miroPerson);
		System.out.println(unaryPerson);
	}
}
