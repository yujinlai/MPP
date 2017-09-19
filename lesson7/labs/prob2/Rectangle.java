package lesson7.labs.prob2;

public final class Rectangle implements Polygon {
	final private double width;
	final private double length;

	public Rectangle(double width, double length) {	
		this.width = width;
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	}
	public double getLength() {
		return length;
	}
	
	@Override
	public double[] getSides() {
	     double[] sides = new double[4];
	     sides[0] = sides[1] = length;
	     sides[2] = sides[3] = width;
	     return sides;
	}
}
