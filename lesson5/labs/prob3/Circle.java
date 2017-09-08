package lesson5.labs.prob3;

public final class Circle implements IPlane{

	private static final double PI = 3.14159;
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
		return PI * radius * radius;
	}

}
