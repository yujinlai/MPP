package lesson8.labs.prob4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Good {
	public static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raru", "Sbrb", "Scott");
	
	public static void main(final String[] args) {
		Good good = new Good();
		
		System.out.println(String.format("Friends with names that length equal 4 contains 'r' not contains 'a'" 
				+ ": " + good.countWords(friends, 'r', 'a', 4)));
	}
	
	public int countWords(List<String> words, char c, char d, int len) {
		return 
		     words.stream()   //convert list to stream
			      .filter(name -> (name.length() == len))
			      .filter(name -> (name.contains(String.valueOf(c))))
			      .filter(name -> (!name.contains(String.valueOf(d))))
			      .collect(Collectors.toList()).size();
	}
}

