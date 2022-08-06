package mm.creational.abstractFactory;

public class Main {

	public static void main(String[] args) {

		FactoryProvider factoryProvider = new FactoryProvider();
		CarFactory carFactory = factoryProvider.createFactory(CarType.AUDI_A4);

		Car sedan = carFactory.createSedan();
		Car combi = carFactory.createCombi();

		System.out.println("sedan: " + sedan.getName());
		System.out.println("combi: " + combi.getName());
	}
}
