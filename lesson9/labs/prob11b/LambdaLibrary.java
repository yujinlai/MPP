package lesson9.labs.prob11b;

import java.util.List;
import java.util.stream.Collectors;

import lesson9.labs.prob11b.Employee;

public class LambdaLibrary {
	public static final 
	   TriFunction<List<Employee>, Integer, Character,String> EMPLOYEE_CANDIDATES 
	           = (list, salarlyAmount, lastNameCharacterbeginwith) -> list.stream()
	           .filter((Employee e) -> e.getSalary()>salarlyAmount)
	           .filter((Employee e) -> e.getLastName().charAt(0)>lastNameCharacterbeginwith)
	           .map(e -> e.getFirstName() + " " + e.getLastName())
	           .sorted()
	           .collect(Collectors.joining(", "));
}