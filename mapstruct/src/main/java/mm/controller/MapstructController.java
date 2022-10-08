package mm.controller;

import mm.model.ClassA;
import mm.model.DTOClassA;
import mm.repositories.ClassARepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/classA")
	public DTOClassA saveClassA(@RequestBody DTOClassA dtoClassA) {

//		DTOClassA dtoClassA1 = new DTOClassA();
//		dtoClassA1.setId(dtoClassA.getId());
//		dtoClassA1.setClassBList(dtoClassA.getClassBList());
//
//		return dtoClassA1;

		return dtoClassA;
	}

}
