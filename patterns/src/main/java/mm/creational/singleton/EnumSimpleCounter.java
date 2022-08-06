package mm.creational.singleton;

public enum EnumSimpleCounter {

	COUNTER;

	private int count = 0;

	public void increment() {count++;}

	public int getCount() {return count;}
}
