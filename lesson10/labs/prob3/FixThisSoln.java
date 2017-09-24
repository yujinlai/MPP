package lesson10.labs.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixThisSoln {
	/* This method creates a compiler error -- try to fix it*/
	List<String> processList(List<String> list)  {

	    return list.stream()
	    		   .map(x -> doNothingIfShort(x)) // This will fail to compile 
	               .collect(Collectors.toList());
	 
	}
	
	public static void main(String[] args) {
		FixThisSoln ft = new FixThisSoln();
		List<String> words1 = Arrays.asList("not", "too", "big", "yet");
		System.out.println(ft.processList(words1));
		List<String> words2 = Arrays.asList("not1", "too2", "big", "yet");
		System.out.println(ft.processList(words2));
	}
	
	public static String doNothingIfShort(String input) {
		try {
		    if (input.length() > 3) 
		    	throw new InputTooLongException();
		    else 
		    	return input;
		} catch(InputTooLongException e) {
			throw new RuntimeException(e);
		}
	}
	
	static class InputTooLongException extends Exception {
		private static final long serialVersionUID = 1L;
		public InputTooLongException() {
			super("Must be length 3 or less");
		}
		public InputTooLongException(String s) {
			super(s);
		}
		public InputTooLongException(Throwable t) {
			super(t);
		}
	}
}
