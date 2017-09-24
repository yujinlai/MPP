package lesson10.labs.prob5.soln2;

import lesson10.labs.prob5.Employee;

public class LibraryCompanion {
	public static boolean salaryGreaterThan100000(Employee e){
		return e.getSalary() > 100000 ? true : false;
	}
	
	public static boolean lastNameAfterM(Employee e) {
		return e.getLastName().charAt(0) > 'M' ? true : false;
	}
	
	public static String fullName(Employee e) {
		return e.getFirstName() + " " + e.getLastName();
	}
}
