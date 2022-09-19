package mm.bootstrap;

import java.util.List;
import java.util.Set;
import mm.model.Category;
import mm.model.Difficulty;
import mm.model.Ingredient;
import mm.model.Notes;
import mm.model.Recipe;
import mm.repository.CategoryRepository;
import mm.repository.IngredientRepository;
import mm.repository.NoteRepository;
import mm.repository.RecipeRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile("default")
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final NoteRepository noteRepository;
	private final IngredientRepository ingredientRepository;

	public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, NoteRepository noteRepository,
			IngredientRepository ingredientRepository) {
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.noteRepository = noteRepository;
		this.ingredientRepository = ingredientRepository;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

		Category category1 = new Category();
		category1.setDescription("category1");

		Recipe recipe5 = new Recipe();
		recipe5.setDescription("recipe5");
		recipe5.setDifficulty(Difficulty.HARD);

		category1.setRecipes(List.of(recipe5));
		recipe5.setCategories(List.of(category1));

		Notes notes1 = new Notes();
		notes1.setDescription("note1");
		notes1.setRecipe(recipe5);
		recipe5.setNotes(notes1);

		Ingredient ingredient1 = new Ingredient();
		ingredient1.setDescription("ingredient1");
		recipe5.setIngredients(Set.of(ingredient1));
		ingredient1.setRecipe(recipe5);


//		ingredientRepository.save(ingredient1);
		noteRepository.save(notes1);
		recipeRepository.save(recipe5);
		categoryRepository.save(category1);
	}
}
