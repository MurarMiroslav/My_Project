package com.example.scoopcsvdatagenerator.columns;

import java.util.Random;

public class IntegerColumn extends Column {


	public IntegerColumn(Random random, int promilleErrorRate) {
		super(random, promilleErrorRate);
	}

	@Override
	protected String createValidData() {
		return String.valueOf(random.nextInt());
	}

	@Override
	protected String createInvalidData() {
		return randomString(random.nextInt(10));
	}

	@Override
	public String toString() {
		return "IntegerColumn{" +
				"random=" + random +
				", primiller error= " + super.promilleErrorRate +
				'}';
	}
}
