package mm.creational.factory;

public class PcGame implements Game {

	private final String name;

	public PcGame(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
