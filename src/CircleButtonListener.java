package drawing;

import java.awt.Color;
import java.awt.Point;

public class CircleButtonListener extends ShapeButtonListener {
	
	public CircleButtonListener(Drawing drawing){
		super(drawing);
	}
	
	
	protected Shape createShape() {
		double width = Math.abs(destination.getX()-origin.getX());
		double height = Math.abs(destination.getY()-origin.getY());
		double radius = Math.max(width, height)/2;
		double centerX = (destination.getX()+origin.getX())/2;
		double centerY = (destination.getY()+origin.getY())/2;
		Point center = new Point((int)centerX, (int)centerY);
		Circle c = new Circle(center, radius, Color.RED);
		return c;
	}
}
