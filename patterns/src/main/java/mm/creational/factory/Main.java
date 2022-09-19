package mm.creational.factory;

public class Main {

	public static void main(String[] args) {

		String name = "PcGame";

		GameFactory gameFactory;
		if (name.equals("PcGame")) {
			gameFactory = new PcGameCreator();
		} else if (name.equals("BoardGame")) {
			gameFactory = new BoardGameCreator();
		} else {
			throw new IllegalArgumentException();
		}

		Game game = gameFactory.createGame();
		System.out.println("GameName: " + game.getName());
	}
}
