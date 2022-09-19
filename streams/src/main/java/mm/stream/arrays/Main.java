package mm.stream.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		String[] array = new String[]{"One", "Two", "Three"};
		Stream.of(array).forEach(System.out::println);
		Arrays.stream(array).forEach(System.out::println);

		System.out.println();

		List<String> list = List.of("One", "Two", "Three");
		list.stream().forEach(System.out::println);
		Stream.of(list).forEach(System.out::println);
		Stream.of(list).flatMap(listt -> listt.stream()).forEach(System.out::println);


		System.out.println("\n========================");
	}
}
