package com.example.scoopcsvdatagenerator.execute;

import com.example.scoopcsvdatagenerator.config.ColumnConfig;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;

@Getter
public class DataGeneratorConfig {

	private final long seed;
	private final List<ColumnConfig<?>> columnConfigs;

	private final List<Integer> fileSizesInMB;

	@JsonCreator
	public DataGeneratorConfig(@JsonProperty("seed") long seed, @JsonProperty("columnConfigs") List<ColumnConfig<?>> columnConfigs,
			@JsonProperty("fileSizesInMB") List<Integer> fileSizesInMB) {
		this.seed = seed;
		this.columnConfigs = columnConfigs;
		this.fileSizesInMB = fileSizesInMB;
	}

}
