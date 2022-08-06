package mm.creational.abstractFactory;

public class ToyotaCorollaFactory implements CarFactory {

	@Override
	public Car createSedan() {
		return new ToyotaCorollaSedanCar();
	}

	@Override
	public Car createCombi() {
		return new ToyotaCorollaCombiCar();
	}
}
