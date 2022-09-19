package mm.creational.abstractFactory;

public class ToyotaCorollaCombiCar implements Car {

	private final String name;

	public ToyotaCorollaCombiCar() {
		this.name = "ToyotaCorollaCombiCar";
	}

	@Override
	public String getName() {
		return name;
	}
}
