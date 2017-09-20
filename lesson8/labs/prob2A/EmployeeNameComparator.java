package lesson8.labs.prob2A;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	//first compare names, if e1 and e2 have the same name, then compare salary
	@Override
	public int compare(Employee e1, Employee e2) {
		int retVal = e1.name.compareTo(e2.name);
		if (retVal!=0) {
			return retVal;
		}
		retVal = e1.salary-e2.salary;
		return retVal;
	}
}
