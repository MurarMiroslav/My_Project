package mm.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(exclude = {"recipes"})
//public class Recipe extends BaseEntity {
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, max = 255)
	private String description;


	@ManyToMany
	@JoinTable(name = "recipe_category",
			joinColumns = @JoinColumn(name ="recipe_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
//	@ManyToMany(mappedBy = "recipies")

//	@ManyToMany
//	@JoinTable(name = "category_recipe",
//			joinColumns = @JoinColumn(name = "recipe_id"),
//			inverseJoinColumns = @JoinColumn(name = "category_id")
//	)

//	@JsonManagedReference
//	@JsonIgnore
	private List<Category> categories;


	@OneToOne

//	@JsonManagedReference
//	@JsonIgnore
	private Notes notes;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")

//	@JsonManagedReference
//	@JsonIgnore
	Set<Ingredient> ingredients;

	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;

	@Lob
	private Byte[] image;

//	@Entity
//	public static class RecipeStaticInnerClass {
//
//		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		private Long id;
//	}
//
//
//	@Entity
//	public class RecipeNonStaticInnerClass {
//
//		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		private Long id;
//	}
}
