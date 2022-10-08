package mm.founded.checker;

public class Row {
	private final int id;

	public Row(int id) {
		this.id = id;
	}


	public boolean isZero() {
		return id == 0;
	}

	public boolean isOne() {
		return id == 1;
	}

	public boolean isTwo() {
		return id == 2;
	}
}