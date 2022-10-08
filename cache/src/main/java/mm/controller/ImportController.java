package mm.controller;

import java.io.IOException;
import mm.service.ImportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImportController {

private final ImportService importService;

	public ImportController(ImportService importService) {
		this.importService = importService;
	}

	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IOException {

		return importService.storeData(file.getInputStream(), file.getName());
	}
}
