package com.example.scoopcsvdatagenerator.columns;

import java.util.Random;

public class BooleanColumn extends Column {

	private final String[] INVALID_DATA = {"null", "12", ""};

	public BooleanColumn(Random random, int promilleErrorRate) {
		super(random, promilleErrorRate);
	}

	@Override
	protected String createValidData() {
		return "" + random.nextBoolean();
	}

	@Override
	protected String createInvalidData() {
		return INVALID_DATA[random.nextInt(INVALID_DATA.length)];
	}
}
