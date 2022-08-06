package mm.creational.factory;

public class PcGameCreator implements GameFactory {

	@Override
	public Game createGame() {
		return new PcGame("PcGame");
	}
}
