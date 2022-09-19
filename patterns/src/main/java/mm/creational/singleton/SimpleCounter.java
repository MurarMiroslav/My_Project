package mm.creational.singleton;

public class SimpleCounter {

	private SimpleCounter() {}

	private static final SimpleCounter simpleCounter = new SimpleCounter();

	public static SimpleCounter getSimpleCounter() {
		return simpleCounter;
	}

	private int count = 0;

	public void increment() {count++;}

	public int getCount() {return count;}
}
