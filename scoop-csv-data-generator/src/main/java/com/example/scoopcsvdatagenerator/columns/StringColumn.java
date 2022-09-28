package com.example.scoopcsvdatagenerator.columns;

import java.util.Random;

public class StringColumn extends Column {


	private final static String[] invalidString = {"null", ""};
	private final static int minLength = 1;
	private final static int maxLength = 30;


	public StringColumn(Random random, int promilleErrorRate) {
		super(random, promilleErrorRate);
	}

	@Override
	protected String createValidData() {
		int length = random.nextInt(maxLength - minLength) + minLength;
		return randomString(length);
	}

	@Override
	protected String createInvalidData() {
		return invalidString[random.nextInt(invalidString.length)];
	}

	@Override
	public String toString() {
		return "StringColumn{" +
				"random=" + random +
				", promilleErrorRate=" + promilleErrorRate +
				'}';
	}
}
