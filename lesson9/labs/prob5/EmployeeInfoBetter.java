package lesson9.labs.prob5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class EmployeeInfoBetter {
	static enum SortMethod {BYNAME, BYSALARY};
	Function<Employee, String> byName = e -> e.getName();
	Function<Employee, Integer> bySalary = e -> -e.getSalary();
	HashMap<SortMethod, List<Function>> functionMap = 
			new HashMap<SortMethod, List<Function>>() {
		{
			put(SortMethod.BYNAME, Arrays.asList(byName,bySalary));
			put(SortMethod.BYSALARY, Arrays.asList(bySalary, byName));
		}
	};
	
	@SuppressWarnings("unchecked")
	public void sort(List<Employee> emps, final SortMethod method) {
		Collections.sort(emps,
				Comparator.comparing(functionMap.get(method).get(0)).
				     thenComparing(functionMap.get(method).get(1)));
	}	
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Rick", 50000));
		emps.add(new Employee("Andy", 60000));
		emps.add(new Employee("Tim", 10000));
		EmployeeInfoBetter ei = new EmployeeInfoBetter();
		ei.sort(emps, EmployeeInfoBetter.SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, EmployeeInfoBetter.SortMethod.BYSALARY);
		//System.out.println(emps);
	}
}
