package mm.creational.abstractFactory;

public class ToyotaCorollaSedanCar implements Car {

	private final String name;

	public ToyotaCorollaSedanCar() {
		this.name = "ToyotaCorollaSedanCar";
	}

	@Override
	public String getName() {
		return name;
	}
}
