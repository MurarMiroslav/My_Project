package mm.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

	private String modelName;
	private Engine engine;

}
