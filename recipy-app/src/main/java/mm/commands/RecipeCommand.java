package mm.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import mm.model.BaseEntity;
import mm.model.Category;
import mm.model.Difficulty;
import mm.model.Ingredient;
import mm.model.Notes;

@Data
public class RecipeCommand extends BaseEntity {

	private String description;
	private List<Category> categories = new ArrayList<>();
	private Notes notes;
	private Set<Ingredient> ingredients = new HashSet<>();
	private Difficulty difficulty;
}
