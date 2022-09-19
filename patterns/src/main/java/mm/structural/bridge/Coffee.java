package mm.structural.bridge;

public class Coffee implements Drink {

	private final String name;
	private final String volume;
	private final boolean isAddictive;

	public Coffee(String name, String volume, boolean isAddictive) {
		this.name = name;
		this.volume = volume;
		this.isAddictive = isAddictive;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getVolume() {
		return volume;
	}

	@Override
	public boolean isAddictive() {
		return isAddictive;
	}
}
