package mm.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {

		Consumer<String> printer = (word) -> System.out.println(word);
//		Consumer<String> printer = System.out::println;
		printer.accept("Hello world !");

		Person miroPerson = new Person("Miro", "Murar", "33");
		Consumer<Person> personConsumer = (person) -> System.out.println(person.getName() + " " + person.getSurname() + " => " + person.getAge());
		personConsumer.accept(miroPerson);

		Person misoPerson = new Person("Michal", "Kurbel", "32");
		BiConsumer<Person, Object> personBiConsumer = (miro, michal) -> {
			System.out.println("Miro age: " + miro.getAge() + "; Michal age: " + ((Person) michal).getAge());
		};
		personBiConsumer.accept(miroPerson, misoPerson);

	}
}
