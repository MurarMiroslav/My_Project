package mm.structural.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	private static final int ITERATIONS = 1000;
	private static final int AVAILABLE_CAR_TYPES = 3;

	public static void main(String[] args) {

		final CarFactory carFactory = new CarFactory();
		final List<Car> producedCars = new ArrayList<>(ITERATIONS);
		final Random random = new Random();

		for (int idx = 0; idx < ITERATIONS; idx++) {
			final int carType = random.nextInt(AVAILABLE_CAR_TYPES);
			switch (carType) {
				case 0:
					producedCars.add(carFactory.createSkodaCityGo());
					break;
				case 1:
					producedCars.add(carFactory.createVWGolf());
					break;
				case 2:
					producedCars.add(carFactory.createVWPolo());
					break;
				case 3:
					producedCars.add(carFactory.createVWPoloGTI());
					break;
			}
		}

		System.out.println("I created " + producedCars.size() + " cars, but only " + Engine.instances + " references to Engine object");
		// it will print: 'I created 1000 cars, but only 4 references to Engine object'
	}
}
