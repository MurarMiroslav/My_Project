package mm.creational.singleton;

public class Main {

	public static void main(String[] args) {

		SimpleCounter simpleCounter1 = SimpleCounter.getSimpleCounter();
		SimpleCounter simpleCounter2 = SimpleCounter.getSimpleCounter();

		System.out.println("simpleCounter1: " + simpleCounter1.getCount());
		System.out.println("simpleCounter2: " + simpleCounter2.getCount());

		simpleCounter1.increment();
		simpleCounter2.increment();

		System.out.println("simpleCounter1: " + simpleCounter1.getCount());
		System.out.println("simpleCounter2: " + simpleCounter2.getCount());


		System.out.println("\n");
		EnumSimpleCounter enumSimpleCounter1 = EnumSimpleCounter.COUNTER;
		EnumSimpleCounter enumSimpleCounter2 = EnumSimpleCounter.COUNTER;

		System.out.println("enumSimpleCounter1: " + enumSimpleCounter1.getCount());
		System.out.println("enumSimpleCounter2: " + enumSimpleCounter2.getCount());

		enumSimpleCounter1.increment();
		enumSimpleCounter2.increment();

		System.out.println("enumSimpleCounter1: " + enumSimpleCounter1.getCount());
		System.out.println("enumSimpleCounter2: " + enumSimpleCounter2.getCount());


		System.out.println("\n");
		LAZYMultiThreadSingleton LAZYMultiThreadSingleton1 = LAZYMultiThreadSingleton.getMultiThreadSingleton();
		LAZYMultiThreadSingleton LAZYMultiThreadSingleton2 = LAZYMultiThreadSingleton.getMultiThreadSingleton();

		System.out.println("LAZYMultiThreadSingleton1: " + LAZYMultiThreadSingleton1.getCount());
		System.out.println("LAZYMultiThreadSingleton2: " + LAZYMultiThreadSingleton2.getCount());

		LAZYMultiThreadSingleton1.increment();
		LAZYMultiThreadSingleton2.increment();

		System.out.println("LAZYMultiThreadSingleton1: " + LAZYMultiThreadSingleton1.getCount());
		System.out.println("LAZYMultiThreadSingleton2: " + LAZYMultiThreadSingleton2.getCount());
	}
}
