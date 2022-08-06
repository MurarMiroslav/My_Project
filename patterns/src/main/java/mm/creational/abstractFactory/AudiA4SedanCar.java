package mm.creational.abstractFactory;

public class AudiA4SedanCar implements Car {

	private final String name;

	public AudiA4SedanCar() {
		this.name = "AudiA4Sedan";
	}

	@Override
	public String getName() {
		return name;
	}
}
