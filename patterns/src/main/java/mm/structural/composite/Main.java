package mm.structural.composite;

public class Main {

	public static void main(String[] args) {
		CompositeEditor editor = new Editor();
		editor.createLine("dotted");
		editor.createLine("another");

		editor.drawShortAllAtPoint(new Point(50,50));
	}
}
