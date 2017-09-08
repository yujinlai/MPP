package lesson3.labs.prob3.composition;

public class Circle {
	public static final double pi = 3.1415926;
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double computeArea() {
		return pi * radius * radius;
	}
}
