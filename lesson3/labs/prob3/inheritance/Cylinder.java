package lesson3.labs.prob3.inheritance;

public class Cylinder {
	public static final double pi = 3.1415926;
	private double radius;
	public double height;
	
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	public double computeVolume() {
	    return pi*radius*radius*height;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
