package mm.structural.composite;

import java.util.List;

public abstract class CompositeEditor {

	private final CompositeLine compositeLine = new CompositeLine();

	public void selectAndRemove(final List<Line> lines) {
		lines.forEach(compositeLine::removeLine);
	}

	public void createLine(final String type) {
		if (type.equals("dotted")) {
			compositeLine.addLine(new DottedLine());
		} else {
			compositeLine.addLine(new SolidLine());
		}
	}

	public void drawShortAllAtPoint(final Point point) {
		compositeLine.setStartingPosition(point);
		compositeLine.draw(5.0);
	}
}
