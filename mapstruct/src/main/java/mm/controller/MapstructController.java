package mm.controller;

import mm.model.ClassA;
import mm.repositories.ClassARepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapstructController {

	private ClassARepository classARepository;

	public MapstructController(ClassARepository classARepository) {
		this.classARepository = classARepository;
	}

	@GetMapping("/classA")
	public ClassA getClassA() {
		return classARepository.findById(1L).get();
	}
}
