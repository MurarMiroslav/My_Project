package mm.stream.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {

		ArrayList<Person> persons = new ArrayList<>(List.of(new Person("Miro", "Murar", "33", List.of("Mgr", "Phd")),
				new Person("Michal", "Kurbel", "32", List.of("Ing", "Ing"))));
		persons.add(new Person("Andrej", "Certik", "35", List.of()));

		System.out.println("reduce:");
		long sumAge = persons.stream().map(person -> Long.parseLong(person.getAge()))
				.reduce(45L, (age1, age2) -> age1 + age2);
		System.out.println("sumAge: " + sumAge);

		Optional<Long> optionalSumAge = persons.stream().map(person -> Long.parseLong(person.getAge()))
				.reduce((age1, age2) -> age1 + age2);
		System.out.println("optionalSumAge: " + optionalSumAge.get());

		long sumAgeWithThreeArguments = persons.stream().map(person -> Long.parseLong(person.getAge()))
//				.reduce(1L, (age1, age2) -> age1 + age2, (age1 , age2) -> age1  * age2);
				.reduce(1L, (age1, age2) ->
						{
							System.out.println("age1: " + age1 + " + age2: " + age2 + " ==> " + (age1 + age2));
							return age1 + age2;
						},
						(age1, age2) ->
						{
							System.out.println("age1: " + age1 +  " * age2: " + age2 + " ==> " + (age1 * age2));
							return age1 * age2;
						}
						);

		System.out.println("sumAgeWithThreeArguments: " + sumAgeWithThreeArguments);

		System.out.println("\nROOT: ");
		List<Double> numList = Arrays.asList(9.0, 4.0);
//		double productOfSqrRoots = numList.stream().reduce(1.0, (a, b) -> {
//			System.out.println("a: " + a + ", Math.sqrt(b): " + Math.sqrt(b));
//			return a * Math.sqrt(b);
//		});
		double productOfSqrRoots = numList.parallelStream().reduce(1.0, (a, b) -> {
			System.out.println("a: " + a + ", Math.sqrt(b): " + Math.sqrt(b) + " ==> " + a * Math.sqrt(b));
			return a * Math.sqrt(b);
		});
//		double productOfSqrRoots = numList.parallelStream().reduce(0.0, (a, b) -> a + b);
		System.out.println("\nproductOfSqrRoots: " + productOfSqrRoots);

		numList = Arrays.asList(9.0, 4.0);
		productOfSqrRoots = numList.stream().reduce(1.0, (a, b) -> {
			System.out.println("a: " + a + ", Math.sqrt(b): " + Math.sqrt(b) + " ==> " + a * Math.sqrt(b));
			return a * Math.sqrt(b);
		}, (a, b) -> {
			System.out.println("a: " + a + " * b: " + b + " ==> " + (a * b));
			return a * b;
		});
//		productOfSqrRoots = numList.parallelStream().reduce(0.0, (a, b) -> a + b, (a, b) -> a + b)
		System.out.println("productOfSqrRoots AGAIN: " + productOfSqrRoots);
	}
}
