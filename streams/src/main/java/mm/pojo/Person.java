package mm.pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {

	private final String name;
	private final String surname;
	private final String age;

	private List<String> titles;
}
