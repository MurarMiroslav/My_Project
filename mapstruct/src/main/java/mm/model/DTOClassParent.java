package mm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = As.PROPERTY,
		property = "input",
		visible = true
)

@JsonSubTypes({@Type(
		value = DTOClassChildA.class,
		name = "INPUT")
		, @Type(
		value = DTOClassChildB.class,
		name = "OUTPUT"
)})

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOClassParent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@Enumerated
	public DTOEnumAttribut input;

//	@JsonProperty("input")
//	public String input;

}
