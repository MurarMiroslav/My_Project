package com.example.scoopcsvdatagenerator.execute;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private DataGeneratorConfig dataGeneratorConfig;

	@Override
	public void run(String... args) throws Exception {

		try {
			InputStream is = Runner.class.getResourceAsStream("/config.json");

			//Uvedom si ze tu sa deje Deserializacia lebo z JSON vznika JAVA object, naopak ak JAVA object ukladas do JSON tak to serializujes.
			dataGeneratorConfig = objectMapper.readValue(is, DataGeneratorConfig.class);
		} catch (Exception e) {
			System.out.println("Exception");
		}

		DataGenerator dataGenerator = new DataGenerator(null, null, dataGeneratorConfig);
		dataGenerator.print();
	}
}
