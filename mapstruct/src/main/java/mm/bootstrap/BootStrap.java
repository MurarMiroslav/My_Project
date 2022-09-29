package mm.bootstrap;

import mm.model.ClassA;
import mm.repositories.ClassARepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

	ClassARepository classARepository;

	public BootStrap(ClassARepository classARepository) {
		this.classARepository = classARepository;
	}

	@Override
	public void run(String... args) throws Exception {

		ClassA classA1 = new ClassA();
		ClassA classA2 = new ClassA();
		ClassA classA3 = new ClassA();
		classARepository.save(classA1);
		classARepository.save(classA2);
		classARepository.save(classA3);
	}
}
