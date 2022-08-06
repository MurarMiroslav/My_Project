package mm.function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {
		Person miroPerson = new Person("Miro", "Murar", "33");
		Function<Person, Long> function = person -> Long.parseLong(person.getAge());

		long ageLong = function.apply(miroPerson);
		System.out.println("AgeLong: " + ageLong);


		BiFunction<Person, Long, Person> biFunction = (person, age) -> new Person(person.getName(), person.getSurname(), age + "");
		Person personFromBiFunction = biFunction.apply(miroPerson, 22L);
		System.out.println("personFromBiFunction: " + personFromBiFunction);




		System.out.println("\n");
		ToIntFunction<Person> toIntFunction = person -> Integer.parseInt(person.getAge());
		Person intFunctionPerson = new Person("Miro", "Murar", "33");
		int age = toIntFunction.applyAsInt(intFunctionPerson);
		System.out.println("ageFronIntFunction: " + age);
	}
}
