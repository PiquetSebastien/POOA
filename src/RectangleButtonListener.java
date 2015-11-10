package drawing;

import java.awt.Color;

public class RectangleButtonListener extends ShapeButtonListener {

	public RectangleButtonListener(Drawing drawing){
		super(drawing);
	}
	
	@Override
	protected Shape createShape() {
		double width = Math.abs(destination.getX()-origin.getX());
		double height = Math.abs(destination.getY()-origin.getY());
		Rectangle r = new Rectangle(origin, (int)width, (int)height, Color.BLUE);
		return r;
	}

}
