package mm.structural.flyweight;

import lombok.Data;

@Data
public class Engine {

	public static int instances = 0;

	private String identifier;
	private EngineType engineType;

	public Engine(final String identifier, final EngineType engineType) {
		instances++;
		this.identifier = identifier;
		this.engineType = engineType;
	}

}
