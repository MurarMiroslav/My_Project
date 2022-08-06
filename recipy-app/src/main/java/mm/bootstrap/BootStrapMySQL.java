package mm.bootstrap;

import mm.model.Category;
import mm.repository.CategoryRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "prod"})
public class BootStrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;

	public BootStrapMySQL(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if (categoryRepository.count() == 0L){
			loadCategories();
		}
	}

	private void loadCategories(){
		Category cat1 = new Category();
		cat1.setDescription("American111");
		categoryRepository.save(cat1);

		Category cat2 = new Category();
		cat2.setDescription("American111");
		categoryRepository.save(cat2);
	}
}