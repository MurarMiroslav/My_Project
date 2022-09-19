package mm.structural.bridge;

public class TeaPurchase implements Purchase {

	@Override
	public Drink buy() {
		return new Tea("Green Tea", "100ml", false);
	}
}
