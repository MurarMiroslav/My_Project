package mm.creational.factory;

public class BoardGame implements Game {

	private final String name;

	public BoardGame(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
