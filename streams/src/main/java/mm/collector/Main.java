package mm.collector;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>(List.of(new Person("Miroslav", "Murar", "33", List.of("Mgr", "Phd")),
				new Person("Michal", "Kurbel", "32", List.of("Ing", "Ing")),
				new Person("Andrej", "Certik", "35", List.of("Ing"))));

		System.out.println("joining:");
//		var joiningWithOneArg = persons.stream().collect(Collectors.joining()); 	//error because Person is not CharSequesnce TYPE or SUBTYPE
		var joiningWithZeroArg = persons.stream().map(person -> person.getName()).collect(Collectors.joining());
		System.out.println("joiningWithZeroArg: " + joiningWithZeroArg);
		var joiningWithOneArg = persons.stream().map(person -> person.getName()).collect(Collectors.joining(","));
		System.out.println("joiningWithOneArg: " + joiningWithOneArg);
		var joiningWithThreeArg = persons.stream().map(person -> person.getName()).collect(Collectors.joining(",", "prefix", "sufix"));
		System.out.println("joiningWithThreeArg: " + joiningWithThreeArg);


		System.out.println("\nmapping:");
		var mappingWithTwoArg = persons.stream().collect(Collectors.mapping(person -> person.getName(), groupingBy(p -> p.equals("Miroslav"))));
//		var mappingWithTwoArgs = persons.stream().collect(Collectors.mapping(person -> person.getSurname(), groupingBy(p -> p.equals("Miroslav"))));
//		var mappingWithTwoArgss = persons.stream().collect(Collectors.mapping(person -> person.getName(), toList()));
//		var mappingWithTwoArgsss = persons.stream().collect(Collectors.groupingBy(person -> person.equals("Miroslav"), Collectors.mapping(person -> person.getName(), toList())));
//		var mappingWithTwoArgssss = persons.stream().collect(Collectors.mapping(person -> person.getName(), toList()));


		System.out.println("\nflatMapping:");
		var flatMapping = persons.stream().collect(Collectors.flatMapping(person -> person.getTitles().stream(), toList()));
		System.out.println("flatMapping: " + flatMapping);


		System.out.println("\nfiltering:");
		var filtering = persons.stream().collect(Collectors.filtering(person -> person.getName().equals("Andrej"), toList()));
		System.out.println("filtering: " + filtering);


		System.out.println("\ncollectingAndThen");
		var collectingAndThen = persons.stream().collect(Collectors.collectingAndThen(toList(),
				person -> person.stream().map(p -> p.getName()).collect(Collectors.joining())));
		System.out.println("collectingAndThen: " + collectingAndThen);


		System.out.println("\ncounting");
		var counting = persons.stream().collect(Collectors.counting());
		System.out.println("counting: " + counting);


		System.out.println("\n");
		var summingInt = persons.stream().collect(Collectors.summingInt(person -> Integer.parseInt(person.getAge())));
		System.out.println("summingInt: " + summingInt);


		System.out.println("\naveragingInt");
		var averagingInt = persons.stream().collect(Collectors.averagingInt(person -> Integer.parseInt(person.getAge())));
		System.out.println("averagingInt: " + averagingInt);


		System.out.println();
		var groupingByOneArg = persons.stream().collect(groupingBy((person) -> person.getName()));
		var groupingByTwoArg = persons.stream().collect(groupingBy(person -> person.getName(), groupingBy(p -> p.getSurname())));
//		var groupingByThreeArg = persons.stream().collect(Collectors.groupingBy(person -> person.getName(), () -> new LinkedHashMap(), Collectors.groupingBy(person -> person.getSurname())));	//No idea why error !!! Need ho thave Reference
//		var groupingByThreeArg = persons.stream().collect(Collectors.groupingBy(person -> person.getName(), () -> new LinkedHashMap(), Collectors.groupingBy(p -> p.getSurname())));			//No idea why error !!! Need ho thave Reference
		var groupingByThreeArg = persons.stream().collect(groupingBy(Person::getName, () -> new LinkedHashMap(), groupingBy(Person::getSurname)));

		var groupingByOwnCollector =  persons.stream().collect(groupingBy(person -> person.getName(), new MyCollector<>()));


		var partitionByOneArg = persons.stream().collect(partitioningBy(person -> person.getName().equals("Miroslav")));
		var partitionByTwoArg = persons.stream().collect(partitioningBy(person -> person.getName().equals("Miroslav"), partitioningBy(p -> p.getSurname().equals("Murar"))));
//		var partitionByThreeArg = persons.stream().collect(partitioningBy(person -> person.getName().equals("Miroslav"), new LinkedHashMap<>(), partitioningBy(person -> person.gegetSurname().equals("Murar"))));  //Does not exist with three parameters


		var toMapWithTwoArg = persons.stream().collect(Collectors.toMap(name -> name.getName(), surname -> surname.getSurname()));
		var toMapWithThreeArg = persons.stream().collect(Collectors.toMap(name -> name.getName(), surname -> surname.getSurname(), (name, surname) -> name + " => " + surname));
		System.out.println("toMapWithThreeArg: " + toMapWithThreeArg + "\n");
		toMapWithThreeArg.entrySet().forEach(System.out::println);
		System.out.println();
		toMapWithThreeArg.keySet().forEach(System.out::println);
		System.out.println();
		toMapWithThreeArg.values().forEach(System.out::println);

		var toMapWithFourArg = persons.stream().collect(Collectors.toMap(
				name -> name.getName(), surname -> surname.getSurname(), (name, surname) -> name + " => " + surname, () -> new LinkedHashMap<>()));


		System.out.println();
		var summarizingInt = persons.stream().collect(Collectors.summarizingInt((person) -> Integer.parseInt(person.getAge())));
		System.out.println("summarizingInt.getMin(): " + summarizingInt.getMin());
		System.out.println("summarizingInt.getMax(): " + summarizingInt.getMax());
		System.out.println("summarizingInt.getCount(): " + summarizingInt.getCount());
		System.out.println("summarizingInt.getSum(): " + summarizingInt.getSum());
		System.out.println("summarizingInt.getAverage(): " + summarizingInt.getAverage());


		System.out.println();
		var reducingWithOneParameter = persons.stream().collect(Collectors.reducing((person1, person2) -> new Person(person1.getName(), person1.getSurname(), person1.getAge(), List.of(person2.getName()))));
		System.out.println("Person after CollectorReducing: " + reducingWithOneParameter.get());
		var reducingWithTwoParameter = persons.stream().collect(Collectors.reducing("Person: ", (person1, person2) ->  person1.toString() + " " +  person2.toString()));
		System.out.println("reducingWithTwoParameter: " + reducingWithTwoParameter);
		var reducingWithThreeParameter = persons.stream().collect(Collectors.reducing(0L, person -> Long.parseLong(person.getAge()), (x, y) -> x + y));
		System.out.println("reducingWithThreeParameter: " + reducingWithThreeParameter);


		var x = new ArrayList<>();
	}
}



