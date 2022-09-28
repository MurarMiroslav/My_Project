package com.example.scoopcsvdatagenerator.config;

import com.example.scoopcsvdatagenerator.columns.BooleanColumn;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Random;

public class BooleanColumnConfig implements ColumnConfig<BooleanColumn> {

	private final int promilleErrorRate;

	@JsonCreator
	public BooleanColumnConfig(@JsonProperty("promilleErrorRate") int promilleErrorRate) {

		this.promilleErrorRate = promilleErrorRate;
	}

	@Override
	public BooleanColumn buildColumn(Random random) {
		return new BooleanColumn(random, promilleErrorRate);
	}
}
