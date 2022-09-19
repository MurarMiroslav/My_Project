package mm.structural.flyweight;

import java.util.List;

public class CarFactory {

	private static final List<Engine> ENGINES = List.of(
			new Engine("octavia", EngineType.DIESEL),
			new Engine("polo", EngineType.DIESEL),
			new Engine("poloGTI", EngineType.GASOLINE),
			new Engine("golf", EngineType.GASOLINE),
			new Engine("e", EngineType.ELECTRIC));

	private static Engine findEngineByKey(final String key) {
		return ENGINES.stream()
				.filter(engine -> engine.getIdentifier().equals(key))
				.findFirst()
				.orElseThrow();
	}

	public Car createSkodaCityGo () {
		return new Car("SKODA", findEngineByKey("octavia"));
	}

	public Car createVWPolo() {
		return new Car("VW", findEngineByKey("polo"));
	}

	public Car createVWPoloGTI() {
		return new Car("VW", findEngineByKey("poloGTI"));
	}

	public Car createVWGolf() {
		return new Car("VW",findEngineByKey("golf"));
	}

}
