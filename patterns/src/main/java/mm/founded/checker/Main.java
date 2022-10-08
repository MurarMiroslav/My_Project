package mm.founded.checker;


public class Main {

	public static void main(String[] args) {
		Row row0 = new Row(0);
		Row row1 = new Row(1);
		Row row2 = new Row(2);

//		TransformationRowSelector transformationRowSelector = TransformationRowSelector();

		var ZERO_check_row0 = TransformationRowSelector.ZERO.check(row0);
		System.out.println("Row0 under ENUM.ZERO: " + ZERO_check_row0 );
		var ZERO_check_row1 = TransformationRowSelector.ZERO.check(row1);
		System.out.println("Row1 under ENUM.ZERO: " + ZERO_check_row1 );
		var ZERO_check_row2 = TransformationRowSelector.ZERO.check(row2);
		System.out.println("Row2 under ENUM.ZERO: " + ZERO_check_row2 );
		System.out.println();
		var ONE_check_row0 = TransformationRowSelector.ONE.check(row0);
		System.out.println("Row0 under ENUM.ONE: " + ONE_check_row0 );
		var ONE_check_row1 = TransformationRowSelector.ONE.check(row1);
		System.out.println("Row1 under ENUM.ONE: " + ONE_check_row1 );
		var ONE_check_row2 = TransformationRowSelector.ONE.check(row2);
		System.out.println("Row2 under ENUM.ONE: " + ONE_check_row2 );
		System.out.println();
		var TWO_check_row0 = TransformationRowSelector.TWO.check(row0);
		System.out.println("Row0 under ENUM.TWO: " + TWO_check_row0 );
		var TWO_check_row1 = TransformationRowSelector.TWO.check(row1);
		System.out.println("Row1 under ENUM.TWO: " + TWO_check_row1 );
		var TWO_check_row2 = TransformationRowSelector.TWO.check(row2);
		System.out.println("Row2 under ENUM.TWO: " + TWO_check_row2 );
	}
}