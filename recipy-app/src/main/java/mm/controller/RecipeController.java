package mm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.websocket.server.PathParam;
import mm.commands.RecipeCommand;
import mm.converters.RecipeToRecipeCommandConverter;
import mm.exception.NotFoundException;
import mm.model.Recipe;
import mm.repository.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RecipeController {

	private final RecipeRepository recipeRepository;

	public RecipeController(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@RequestMapping("/list")
	public ResponseEntity<List<Recipe>> getRecipes() {

		List<Recipe> recipeList = new ArrayList<>();
		Iterator<Recipe> iterator = recipeRepository.findAll().iterator();

		while (iterator.hasNext()) {
			recipeList.add(iterator.next());
		}

		return new ResponseEntity<List<Recipe>>(recipeList, HttpStatus.OK);
	}

	@RequestMapping("/recipe/{id}")
	public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
		Recipe recipe;
		try {
			recipe = recipeRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new NotFoundException("Recipe Not Found");
		}
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@GetMapping("/recipe")
	@ResponseBody
	public String getFoos(@RequestParam(required = false) String id, @RequestParam(required = false) String id2,
			@RequestParam(required = false) String id3) {
		return "ID: " + id + " ID2: " + id2 + " ID3: " + id3;
	}

//	@GetMapping(name = "/param")  	//error ako krava jebal som sa s tym 45 minut !!!
//	@GetMapping( "/param")			//ok
	@GetMapping(path = "/param")	//ok
	public @ResponseBody Recipe getRecipeByParam(@RequestParam(required = false) String description){
		Recipe recipeGetByDescription = recipeRepository.findByDescription(description).get();

		return recipeGetByDescription;
	}

	@GetMapping(path = "/param/{id}")
//	public @ResponseBody Recipe getRecipeByParam(@PathVariable Long id, @RequestParam(required = false) String description){
	public Recipe getRecipeByParam(@PathVariable Long id, @RequestParam(required = false) String description){
		Recipe recipeGetByDescription = recipeRepository.findByDescription(description).get();
		Recipe recipeGetById = recipeRepository.findById(id).get();

		if (Objects.equals(recipeGetByDescription.getId(), recipeGetById.getId())) {
			return recipeGetByDescription;
		}
		return null;
	}


	@RequestMapping("/recipe")
	public ResponseEntity<RecipeCommand> getRecipe() {

		RecipeToRecipeCommandConverter converter = new RecipeToRecipeCommandConverter();
		RecipeCommand recipeCommand = converter.convert(recipeRepository.findByDescription("recipe1").get());

		return new ResponseEntity<>(recipeCommand, HttpStatus.OK);
	}


	@PostMapping("/recipe")
	public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe) {

		Recipe newRecipe = new Recipe();
		newRecipe.setDescription(recipe.getDescription());
		newRecipe.setDifficulty(recipe.getDifficulty());

		recipeRepository.save(newRecipe);

		return new ResponseEntity<>(newRecipe, HttpStatus.OK);
	}


	@PostMapping("/picture")
	public void postPicture(MultipartFile file) {

		Recipe recipe = recipeRepository.findById(1L).get();

		recipe.setImage(pictureToBytes(file));

		recipeRepository.save(recipe);
	}

	private Byte[] pictureToBytes(MultipartFile file) {
		try {
			Byte[] byteObjects = new Byte[file.getBytes().length];

			int i = 0;

			for (byte b : file.getBytes()) {
				byteObjects[i++] = b;
			}

			return byteObjects;
		} catch (IOException e) {
			//todo handle better
			e.printStackTrace();
			return null;
		}
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public NotFoundException handleNotFound(NotFoundException exception){

		return new NotFoundException(exception.getMessage());
	}
}
