package com.example.scoopcsvdatagenerator.execute;

import com.example.scoopcsvdatagenerator.columns.Column;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataGenerator {

	private final Random random;
	private final String directory;
	private final String filenamePrefix;
	private final List<Column> columns;
	private final DataGeneratorConfig dataGeneratorConfig;


	public DataGenerator(String directory, String filenamePrefix, DataGeneratorConfig dataGeneratorConfig) {
		this.random = new Random(dataGeneratorConfig.getSeed());
		this.directory = directory;
		this.filenamePrefix = filenamePrefix;
		this.dataGeneratorConfig = dataGeneratorConfig;
		this.columns = dataGeneratorConfig.getColumnConfigs().stream().map(columnConfig -> columnConfig.buildColumn(random))
				.collect(Collectors.toList());
	}

//	private void reset() {
//		random.setSeed(testDataGeneratorConfig.getSeed());
//	}
//
//
//	public List<Path> generate(List<Integer> fileSizesInMB) throws IOException {
//		reset();
//		if (fileSizesInMB == null || fileSizesInMB.isEmpty()) {
//			throw new IllegalArgumentException("Must at least provide 1 valid run configuration");
//		}
//		Collections.sort(fileSizesInMB);
//		ArrayList<Path> generatedFiles = new ArrayList<>();
//
//		Path lastGeneratedFile = null;
//		int lastFileSize = 0;
//		for (int targetSize : fileSizesInMB) {
//			lastGeneratedFile = generate(lastGeneratedFile, lastFileSize, targetSize);
//			lastFileSize = targetSize;
//			generatedFiles.add(lastGeneratedFile);
//		}
//
//		return generatedFiles;
//	}
//
//	private Path generate(Path generatedFile, long initialSizeInMb, long targetSizeInMB) throws IOException {
//		Path outputPath = Path.of(directory, filenamePrefix + targetSizeInMB + ".csv");
//		boolean append = false;
//		if (generatedFile != null) {
//			log.info("Copying {} to {}", generatedFile, outputPath);
//			Files.copy(generatedFile, outputPath, StandardCopyOption.REPLACE_EXISTING);
//			append = true;
//		}
//
//		log.info("Generating {} (additional {}) mb data", targetSizeInMB, (targetSizeInMB - initialSizeInMb));
//		try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputPath.toFile(), append))) {
//
//			long maxSize = targetSizeInMB * 1024 * 1024;
//			long size = initialSizeInMb * 1024 * 1024;
//			String[] line = new String[columns.size()];
//			String lineAsString;
//			while (size < maxSize) {
//				for (int j = 0; j < columns.size(); j++) {
//					line[j] = columns.get(j).createData();
//				}
//				lineAsString = String.join(",", line) + "\n";
//				byte[] bytes = lineAsString.getBytes();
//				size += bytes.length;
//
//				out.write(bytes);
//			}
//		}
//		return outputPath;
//	}

	public void print() {
		columns.forEach(System.out::println);
	}

}
