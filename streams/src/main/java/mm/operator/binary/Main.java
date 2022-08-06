package mm.operator.binary;

import java.util.function.BinaryOperator;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {

		//In this example, the BiFunction<Integer, Integer, Integer> which accepts and returns the same type, can be replaced with BinaryOperator<Integer>.
		BinaryOperator<Person> binaryOperator = (person1, person2) -> new Person(person1.getName(), person2.getSurname(), "99");
		Person miroPerson = new Person("Miro", "Murar", "33");
		Person misoPerson = new Person("Micha;", "Kurbel", "32");

		Person binaryOperatorPerson = binaryOperator.apply(miroPerson, misoPerson);
		System.out.println(binaryOperatorPerson);
	}
}
