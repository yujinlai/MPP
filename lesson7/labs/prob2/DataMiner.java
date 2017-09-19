package lesson7.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class DataMiner {
	List<ClosedCurve> objects = new ArrayList<>();
	public static void main(String[] args) {
		DataMiner dm = new DataMiner();
		dm.objects.add(new Rectangle(5,7)); //24
		dm.objects.add(new Rectangle(2,9));  //22
		dm.objects.add(new Circle(6)); //37.68
		dm.objects.add(new EquilateralTriangle(10)); //30
		dm.objects.add(new Eclipse(4, 8)); //128
		System.out.println(dm.computeAveragePerimeter());
	}
	
	//OO (good) way of performing computation
	public double computeAveragePerimeter() {
		if(objects == null || objects.isEmpty()) return 0.0;
		double sum = 0.0;
		for(int i = 0; i < objects.size(); ++i) {
			sum += objects.get(i).computePerimeter();
		}
		return sum/objects.size();
	}
}
