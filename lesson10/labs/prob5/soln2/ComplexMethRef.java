package lesson10.labs.prob5.soln2;

import java.util.List;
import java.util.stream.Collectors;

import lesson10.labs.prob5.Employee;

public class ComplexMethRef {
	public static String asString(List<Employee> list) {
        return list.stream()
	    .filter(LibraryCompanion::salaryGreaterThan100000)
	    .filter(LibraryCompanion::lastNameAfterM)
	    .map(LibraryCompanion::fullName)
	    .sorted()
	    .collect(Collectors.joining(", ")).toString();
	}
}
