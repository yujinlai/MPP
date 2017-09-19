package lesson7.labs.prob2;

public class Eclipse implements ClosedCurve {
	final private double a; //the length of the semi-major axis
	final private double E; //eccentricity
	
	public Eclipse(double a, double E) {
		this.a = a;
		this.E = E;
	}
	
	public double getA() {
		return a;
	}
	
	public double getE() {
		return E;
	}
	
	@Override
	public double computePerimeter() {
		return 4 * a * E; 
	}
}
