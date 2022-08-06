package mm.creational.singleton;

public class LAZYMultiThreadSingleton {

	private LAZYMultiThreadSingleton() {}			//EAGER ani nema zmysel lebo instancia by vznikala este pred vznikom akehokolvek vlakna ? 
	private static LAZYMultiThreadSingleton LAZYMultiThreadSingleton;
	public static LAZYMultiThreadSingleton getMultiThreadSingleton() {
		if (LAZYMultiThreadSingleton == null) {
			synchronized (LAZYMultiThreadSingleton.class) {
				if (LAZYMultiThreadSingleton == null) {
					LAZYMultiThreadSingleton = new LAZYMultiThreadSingleton();
				}
			}
		}
		return LAZYMultiThreadSingleton;
	}


	private int count;

	public int getCount() {
		return count;
	}

	public void increment() {
		count++;
	}
}
