package lesson10.labs.prob4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GuestListJava8 {
	 
	public static void main(String[] args) {
		final boolean yes = true;
		final boolean no = false;
		GuestListJava8 gl = new GuestListJava8();
		List<Guest> invited 
		  = Arrays.asList(new Guest("Joe Stevens", Status.COMMON, Gender.M, 5, yes),
				          new Guest("Susan Richards", Status.GOLD, Gender.F, 10, no),
				          new Guest("Toni Smith", Status.COMMON, Gender.F, 4, yes),
				          new Guest("Anthony Hawkins", Status.ILLEGAL, Gender.M, 0, yes),
				          new Guest("Tony Thomas", Status.SILVER, Gender.M, 8, no),
				          new Guest("Antoinette Cerisier", Status.SILVER, Gender.F, 7, yes),
				          new Guest("Ricardo Salhuega", Status.COMMON, Gender.M, 2, yes));
		
		gl.printListOfExpectedFemaleGuests(invited);
		
	}
	private boolean checkLegal(Guest g) throws IllegalGuestException {
		boolean isIllegal = (g.getStatus() == Status.ILLEGAL);
		if(isIllegal) throw new IllegalGuestException(String.format(
					"Illegal guest %s has attempted entry to the event", g.getName()));
		else return true;
	}
	
	public  boolean uncheckedLegal(Guest g) {
		try {
			return checkLegal(g);
		} catch(IllegalGuestException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void printListOfExpectedFemaleGuests(List<Guest> invited) {
		//implement
		List<String> names = invited.stream()
				.filter(g -> uncheckedLegal(g) && g.getGender() == Gender.F && g.isPlanningToCome())
				.map(g -> g.getName())
				.collect(Collectors.toList());
		
		System.out.println(names);
	}
	
	
	class IllegalGuestException extends Exception {
		private static final long serialVersionUID = 1L;
		IllegalGuestException() {
			super("An illegal guest has attempted entry.");
		}
		IllegalGuestException(String msg) {
			super(msg);
		}
		IllegalGuestException(Throwable t) {
			super(t);
		}
	}
}
