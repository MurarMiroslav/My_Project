package mm.stream.map;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = List.of(new Person("Miro", "Murar", "33", List.of("Mgr", "Phd")), new Person("Michal", "Kurbel", "32", List.of("Ing", "Ing")));

		persons.stream()
				.map(person -> person.getName())
				.forEach(System.out::println);

		System.out.println();
		persons.stream()
				.mapToInt(person -> Integer.parseInt(person.getAge()))
				.forEach(System.out::println);

		System.out.println();
		persons.stream()
				.flatMap(person -> Stream.of(person.getSurname()))
				.forEach(System.out::println);

		System.out.println();
		persons.stream()
				.flatMap(person -> person.getTitles().stream())
				.forEach(System.out::println);

		System.out.println();
		persons.stream()
				.flatMap(person -> Stream.of(person.getTitles()))
				.forEach(System.out::println);

		System.out.println();
		persons.stream()
				.flatMapToInt(person -> IntStream.of(Integer.parseInt(person.getAge())))
				.forEach(System.out::println);
	}
}
