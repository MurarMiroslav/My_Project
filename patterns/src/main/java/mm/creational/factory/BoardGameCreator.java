package mm.creational.factory;

public class BoardGameCreator implements GameFactory{

	@Override
	public Game createGame() {
		return new BoardGame("Boardgame");
	}
}
