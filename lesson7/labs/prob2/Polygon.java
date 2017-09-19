package lesson7.labs.prob2;

public interface Polygon extends ClosedCurve {
	 abstract double[] getSides();
     default double computePerimeter() {
    	 double[] sides = getSides();
    	 double perimeter = 0;
    	 for(double side : sides)
    		 perimeter += side;
    	 return perimeter;
     }
}
