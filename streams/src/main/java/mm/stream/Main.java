package mm.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Stream;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {

		ArrayList<Person> persons = new ArrayList<>(List.of(new Person("Miro", "Murar", "33", List.of("Mgr", "Phd")),
				new Person("Michal", "Kurbel", "32", List.of("Ing", "Ing"))));
		persons.add(new Person("Andrej", "Certik", "35", List.of()));

		Comparator<Person> comparator = (person1, person2) -> {
			if (Long.parseLong(person1.getAge()) > Long.parseLong(person2.getAge())) {
				return 1;
			} else if (Long.parseLong(person1.getAge()) == Long.parseLong(person2.getAge())) {
				return 0;
			} else {
				return -1;
			}
		};
		System.out.println("Sorted:");
		persons.stream()
				.sorted(comparator)
				.forEach(System.out::println);


		System.out.println("\nSkipped 1:");
		persons.stream()
				.skip(1)
				.forEach(System.out::println);


		System.out.println("\nLimit 1:");
		persons.stream()
				.limit(1)
				.forEach(System.out::println);


		System.out.println("\nPeek:");
		persons.stream()
				.peek(person -> {
//					List<String> titles = person.getTitles(); //error reference odkaz does not exists
					List<String> titles = new ArrayList<>(person.getTitles());
					titles.add("FRIENDS");
					person.setTitles(titles);
				})
				.forEach(System.out::println);


		System.out.println("\nTakeWhile:");
		persons.stream()
				.takeWhile(person -> Long.parseLong(person.getAge()) < 34)
				.forEach(System.out::println);

		System.out.println("\nTake a while not working because first does not fulfill condition");
		persons.add(0, persons.get(2));
		persons.remove(3);
		persons.stream()
				.takeWhile(person -> Long.parseLong(person.getAge()) < 34)
				.forEach(System.out::println);


		System.out.println("\nDropWhile:");
		persons.stream()
				.dropWhile(person -> Long.parseLong(person.getAge()) < 34)
				.forEach(System.out::println);

		System.out.println("\n\tReversing persons...");
		Collections.reverse(persons);
		persons.stream()
				.dropWhile(person -> Long.parseLong(person.getAge()) < 34)
				.forEach(System.out::println);


		System.out.println("\ntoArray:");
		Object[] personAges = persons.stream().map(person ->  Long.parseLong(person.getAge())).toArray();
		System.out.println("personAges: " + personAges);
		System.out.println("personAges => (Arrays.toString): " + Arrays.toString(personAges));

		Person[] personsWithName = persons.stream().map(person -> new Person(person.getName(), null, null, null))
				.toArray(Person[]::new);
		System.out.println("personsWithName: " + Arrays.toString(personsWithName));


		IntFunction<Person[]> intFunctionPerson = (value) -> {
			System.out.println("Value: " + value);
			Person [] personIntFunction = new Person[value];
//			personIntFunction[value - 1] = new Person(null, null, null, null);
			return personIntFunction;
		};
		Person[] personFromIntFunction = persons.stream().toArray(intFunctionPerson);
		System.out.println("personFromIntFunction: " + Arrays.toString(personFromIntFunction));


		System.out.println("\ncollect:");
		List<Person> listPerson = persons.stream()
				.collect(() -> new ArrayList<>(),
						(array, element) -> array.add(element),
						(array, combinedArray) -> combinedArray.addAll(array));
		System.out.println("listPerson: " + listPerson);


		System.out.println("\nanyMatch, allmatch, noneMatch");
		boolean isAnyoneOlderThan34Years = persons.stream().map(person -> Long.parseLong(person.getAge()))
				.anyMatch(longValue -> longValue > 34);
		System.out.println("isAnyoneOlderThan34Years: " + isAnyoneOlderThan34Years);

		boolean isEverybodyOlder34Years = persons.stream().map(person -> Long.parseLong(person.getAge()))
				.allMatch(longValue -> longValue > 34);
		System.out.println("isEverybodyOlder34Years: " + isEverybodyOlder34Years);

		boolean isNobodyOlder34Years = persons.stream().map(person -> Long.parseLong(person.getAge()))
				.noneMatch(longValue -> longValue > 34);
		System.out.println("isNobodyOlder34Years: " + isNobodyOlder34Years);


		System.out.println("\nfindFirst, findAny");
		Optional<Long> friendSAge = persons.stream().map(person -> Long.parseLong(person.getAge())).findFirst();
		System.out.println("friendSAge: " + friendSAge.get());
		persons.stream().map(person -> Long.parseLong(person.getAge()))
				.findFirst().ifPresent(System.out::println);
		persons.stream().map(person -> Long.parseLong(person.getAge()))
				.findFirst().ifPresent((age) -> {System.out.println("Friend's agfe is: " + age);});

		Collections.reverse(persons);
		persons.stream().map(person -> Long.parseLong(person.getAge()))
				.findAny().ifPresent(System.out::println);




		System.out.println("\nSTATIC INNER CLASSES of STREAM");
		Stream.Builder<String> stringStream = Stream.builder();
		stringStream.add("Hello").add("Ahoj").add("Hallo");
		stringStream.build().forEach(System.out::println);

		System.out.println("\nEmpty stream, useful if method need to have stream as parameter => to avoid nul pointerexception use empty stream");
		Stream<String> stream = Stream.empty();
		stream.forEach(System.out::println);
		System.out.println("Finish of empty stream");

		System.out.println();
		Stream<String> streamOfString = Stream.of("Ahoj");
		streamOfString.forEach(System.out::println);
		streamOfString = Stream.of("Ahoj", "Hello");
		streamOfString.forEach(System.out::println);

		System.out.println();
		Stream<String> value = Stream.ofNullable(null);
		System.out.println("Values of Stream:");
		value.forEach(System.out::println);
		value = Stream.ofNullable("Ahoj");
		System.out.println("Values of Stream:");
		value.forEach(System.out::println);

		System.out.println("\niterate");
		Stream.iterate(0, n -> n + 1)
				.limit(10)		//if you comment it is infinity loop
				.forEach(System.out::println);

		System.out.println();
		Stream.iterate(5, n -> n > 0, n -> n - 1)
				.forEach(System.out::println);

		System.out.println("\ngenerate");
		Random random = new Random();
		Stream.generate(() -> random.nextInt(5))
				.takeWhile(x -> x > 0)
				.forEach(System.out::println);
	}
}
