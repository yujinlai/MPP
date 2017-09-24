package lesson10.labs.prob5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));

		printEmps(emps, 100000, 'M');
		    
	}
	
	private static String fullName(Employee e) {
		return e.getFirstName() + " " + e.getLastName();
	}
	
	public static String asString(List<Employee> list, int lower, Character beginCharacter) {
        return list.stream()
	    .filter(e -> (e.getSalary() > lower))
	    .filter(e -> (e.getLastName().charAt(0) > beginCharacter))
	    .map((Employee e) -> fullName(e))
	    .sorted()
	    .collect(Collectors.joining(", ")).toString();
	}
	
	public static void printEmps(List<Employee> list, int lower, Character beginCharacter) {
		String emps = asString(list, lower, beginCharacter);
		System.out.println(emps);
	}

}
