package com.example.scoopcsvdatagenerator.columns;

import java.util.Random;

public abstract class Column {
	protected Random random;
	public final int promilleErrorRate;

	protected Column(Random random, int promilleErrorRate) {

		this.random = random;
		this.promilleErrorRate = promilleErrorRate;
	}


	public String createData() {
		if (random.nextInt(1000) < promilleErrorRate) {
			return createInvalidData();
		} else {
			return createValidData();
		}
	}

	protected abstract String createValidData();

	protected abstract String createInvalidData();

	protected String randomString(int length) {
		char[] chars = new char[length];
		// 65 - 90 incl are upper case characters
		// 97 - 122 incl are lower case letters
		for (int i = 0; i < length; i++) {
			chars[i] = (char) (random.nextInt(26) + 65 + (random.nextBoolean() ? 0 : 32));
		}
		return new String(chars);
	}

	@Override
	public String toString() {
		return "Column{}";
	}
}
