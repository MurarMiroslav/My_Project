package mm.structural.bridge;

public class Main {

	public static void main(String[] args) {

		Purchase purchaseTea = new TeaPurchase();
		Purchase purchaseCoffee = new CoffeePurchase();

		Drink drinkTea = purchaseTea.buy();
		Drink drinkCoffee = purchaseCoffee.buy();

	}
}
