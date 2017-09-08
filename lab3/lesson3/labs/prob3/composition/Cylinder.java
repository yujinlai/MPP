package lesson3.labs.prob3.composition;

public class Cylinder {
	private Circle circle;
	public double height;

	public Cylinder(Circle circle, double height) {
		this.circle = circle;
		this.height = height;
	}
	
	public Cylinder(double radius, double height) {
		this.circle = new Circle(radius);
		this.height = height;
	}

	public double computeVolume() {
		return circle.computeArea() * height;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
