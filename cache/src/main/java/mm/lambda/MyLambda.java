package mm.lambda;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class MyLambda extends Lambda {

	private final String name;


	public MyLambda(String surname, String name) {
		super(surname);
		this.name = name;
	}
}
