package lesson7.labs.prob2;

public class EquilateralTriangle implements Polygon {
	final private double side;

	public EquilateralTriangle(double side) {	
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	
	@Override
	public double[] getSides() {
	     double[] sides = new double[3];
	     sides[0] = sides[1] = sides[2] = side;
	     return sides;
	}
}
