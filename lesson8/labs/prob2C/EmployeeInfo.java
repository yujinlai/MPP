package lesson8.labs.prob2C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};
	public void sort(List<Employee> emps,  SortMethod method) {
		
		Collections.sort(emps, (e1,e2) ->
		{
			int retVal;
			if(method == SortMethod.BYNAME) {
				retVal = e1.name.compareTo(e2.name);
				if (retVal!=0) {
					return retVal;
				}
				retVal = e1.salary - e2.salary;
			} else {
				retVal = e1.salary - e2.salary;
				if (retVal!=0) {
					return retVal;
				}
				retVal = e1.name.compareTo(e2.name);
			}
			return retVal;
		});
		
		
				
	}

	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Andy", 60000));
		EmployeeInfo ei = new EmployeeInfo();
		ei.sort(emps, EmployeeInfo.SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, EmployeeInfo.SortMethod.BYSALARY);
		System.out.println(emps);
	}
}
