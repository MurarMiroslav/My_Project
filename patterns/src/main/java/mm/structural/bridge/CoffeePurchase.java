package mm.structural.bridge;

public class CoffeePurchase implements Purchase {

	@Override
	public Drink buy() {
		return new Coffee("Arabica", "50 ml", true);
	}
}
