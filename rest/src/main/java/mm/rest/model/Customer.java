package mm.rest.model;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "This is the name", required = true)
	private String name;

	@ApiModelProperty(required = true )
	private String surname;

	@OneToOne(cascade = CascadeType.ALL)
	private Phone phone;
}
