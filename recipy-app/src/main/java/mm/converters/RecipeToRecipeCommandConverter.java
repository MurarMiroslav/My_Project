package mm.converters;

import mm.commands.RecipeCommand;
import mm.model.Recipe;
import org.springframework.core.convert.converter.Converter;


public class RecipeToRecipeCommandConverter implements Converter<Recipe, RecipeCommand> {

	@Override
	public RecipeCommand convert(Recipe recipe) {

		RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setId(recipe.getId());
		recipeCommand.setDescription(recipe.getDescription());
		recipeCommand.setDifficulty(recipe.getDifficulty());


		return recipeCommand;
	}
}
