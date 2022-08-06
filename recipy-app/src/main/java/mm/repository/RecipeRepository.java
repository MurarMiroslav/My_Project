package mm.repository;

import java.util.Optional;
import mm.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

	Optional<Recipe> findByDescription(String description);
}
