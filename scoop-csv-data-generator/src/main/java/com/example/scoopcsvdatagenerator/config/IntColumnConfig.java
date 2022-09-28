package com.example.scoopcsvdatagenerator.config;

import com.example.scoopcsvdatagenerator.columns.IntegerColumn;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Random;
import lombok.Getter;

@Getter
public class IntColumnConfig implements ColumnConfig<IntegerColumn> {

	private final int promilleErrorRate;

	@JsonCreator
	public IntColumnConfig(@JsonProperty("promilleErrorRate") int promilleErrorRate) {

		this.promilleErrorRate = promilleErrorRate;
	}

	@Override
	public IntegerColumn buildColumn(Random random) {
		return new IntegerColumn(random, promilleErrorRate);
	}

}
