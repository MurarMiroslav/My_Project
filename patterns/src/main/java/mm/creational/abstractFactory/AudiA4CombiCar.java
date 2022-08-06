package mm.creational.abstractFactory;

public class AudiA4CombiCar implements Car {

	private final String name;

	public AudiA4CombiCar() {
		this.name = "AudiA4Combi";
	}

	@Override
	public String getName() {
		return name;
	}
}
