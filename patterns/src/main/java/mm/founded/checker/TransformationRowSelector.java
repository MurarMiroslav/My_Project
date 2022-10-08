package mm.founded.checker;


public enum TransformationRowSelector {

	ZERO(row -> {
		return row.isZero();
	}),

	ONE(Row::isOne),

	TWO(row -> {
		return row.isTwo();
	});

	final Checker checker;

	private TransformationRowSelector(Checker checker) {
		this.checker = checker;
	}

	public boolean check(Row row) {
		return checker.check(row);
	}

	private interface Checker {
		boolean check(Row row);
	}
}
