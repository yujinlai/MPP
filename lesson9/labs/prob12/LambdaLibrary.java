package lesson9.labs.prob12;

import java.util.List;
import java.util.stream.Collectors;


public class LambdaLibrary {
	 	  		
	 	  		public static final 
	 	 	   TriFunction<List<Employee>, Character, Integer, Long> COUNT_IN_LASTNAME 
	 	 	  		= (list, charStart, salary) -> list.stream()
	 	  			 .filter(e -> e.getLastName().charAt(0) > charStart)
	 	  			 .filter(e -> e.getSalary() > salary)
	 	  			 .count();
	 	 	  		
	 	 	  	public static final 
		 	 	   TriFunction<List<Employee>, Character, Integer, List<String>> NAMES_IN_FIRSTNAME 
		 	 	  		= (list, charStart, salary) -> list.stream()
		 	 	  				.filter(e -> e.getFirstName().charAt(0) < charStart)
	  			 				.filter(e -> e.getSalary() > salary)
	  			 				.map(e -> e.getFirstName() + " " + e.getLastName())
	  			 				.collect(Collectors.toList());
		 	 	  		
	
	 	  	 
}


