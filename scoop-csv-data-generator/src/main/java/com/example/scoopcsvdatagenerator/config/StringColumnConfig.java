package com.example.scoopcsvdatagenerator.config;

import com.example.scoopcsvdatagenerator.columns.StringColumn;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Random;
import lombok.Getter;

@Getter
public class StringColumnConfig implements ColumnConfig<StringColumn> {

	private final int promilleErrorRate;

	@JsonCreator
	public StringColumnConfig(@JsonProperty("promilleErrorRate") int promilleErrorRate) {

		this.promilleErrorRate = promilleErrorRate;
	}

	@Override
	public StringColumn buildColumn(Random random) {
		return new StringColumn(random, promilleErrorRate);
	}

}
