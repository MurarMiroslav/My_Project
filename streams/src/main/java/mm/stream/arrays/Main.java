package mm.stream.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
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

		String [] arrayString = new String[10];
		List<String> listStrings = List.of("Hello", "World", "Miro", "Michal");
		AtomicInteger yAtomic = new AtomicInteger(0);
//		int yAtomic = 0;
		System.out.println("yAtomic: " + yAtomic.incrementAndGet());

		var Y = listStrings.stream().map(word -> {
//			yAtomic++;
			yAtomic.incrementAndGet();
//			int x = yAtomic++;
			int x = yAtomic.incrementAndGet();
			arrayString[x]= word;
			System.out.println("x: " + x);
			return word + "S";
		})
//				.count()
//				.forEach(System.out::println);
				.collect(Collectors.toList());

		System.out.println("Y: " + Y);
		System.out.println("arrayString: " + Arrays.toString(arrayString));
	}
}
