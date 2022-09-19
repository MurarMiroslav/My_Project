package mm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(exclude = {"recipes"})
//public class Category extends BaseEntity {
public class Category  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;


	//	@ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
	@ManyToMany(mappedBy = "categories")
//	@ManyToMany
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "recipe_category",
//			joinColumns = @JoinColumn(name = "recipe_id"),
//			inverseJoinColumns = @JoinColumn(name = "category_id")
//	)

//	@JsonBackReference
	@JsonIgnore
	private List<Recipe> recipes;


}
