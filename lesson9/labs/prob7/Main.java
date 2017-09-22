package lesson9.labs.prob7;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(4, 5, -2, 0, -3, -1, -5, -4);
		//expected output: [0, -1, -2, -3, -4, 4, -5, 5]
		ordering1(intList);
		List<String> stringList = Arrays.asList("cba", "efg", "doe", "fie", "set");
		//expected output: [cba, fie, doe, efg, set]
		ordering2(stringList);

	}

	//Orders the integers according to this pattern:
	// 0, -1, 1, -2, 2, -3, 3, . . .
	//Using this ordering, this method sorts the list as part of
	//a stream pipeline, and prints to the console
	public static void ordering1(List<Integer> list) {
		Collections.sort(list,
				Comparator.comparing(x -> Math.abs((int) x)).thenComparing(x -> (int) x));
		System.out.println(list);

	}

	//Orders words by first reversing each and comparing
	//in the usual way.  So
	//    cba precedes bed
	//since
	//    cba.reverse() precedes bed.reverse()
	//in the usual ordering
	//Using this ordering, this method sorts the list as part of
	//a stream pipeline, and prints to the console
	public static void ordering2(List<String> words) {
		List<StringBuilder> words2 = new ArrayList<StringBuilder>();
		for(String word:words){
			words2.add(new StringBuilder(word));
		}
		words2.forEach(StringBuilder::reverse);

		List<String> words3 = new ArrayList<String>();
		for (StringBuilder word2 : words2) {
			words3.add(word2.toString());
		}
		words3 = words3.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

		words2.clear();
		for(String word3:words3){
			words2.add(new StringBuilder(word3));
		}
		words2.forEach(StringBuilder::reverse);

		System.out.println(words2);
	}
}
