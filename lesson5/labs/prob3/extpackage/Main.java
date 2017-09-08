package lesson5.labs.prob3.extpackage;

import java.util.ArrayList;
import java.util.List;

import lesson5.labs.prob3.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<IPlane> planes = new ArrayList<>();
		planes.add(new Triangle(2.2, 3));
		planes.add(new Rectangle(1.2, 3.5));
		planes.add(new Circle(2.5));
		
		double sumArea = 0;
		for(IPlane p : planes)
			sumArea += p.computeArea();
					
		System.out.print("Sum of Areas =");
		System.out.println(sumArea);
	}

}
