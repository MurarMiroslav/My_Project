package mm.creational.abstractFactory;

public class AudiA4Factory implements CarFactory {

	@Override
	public Car createSedan() {
		return new AudiA4SedanCar();
	}

	@Override
	public Car createCombi() {
		return new AudiA4CombiCar();
	}
}
