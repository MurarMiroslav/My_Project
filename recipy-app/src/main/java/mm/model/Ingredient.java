package mm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(exclude = {"recipe"})
//public class Ingredient extends BaseEntity {
public class Ingredient  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String description;

	@ManyToOne

//	@JsonBackReference
	@JsonIgnore
	private Recipe recipe;
}
