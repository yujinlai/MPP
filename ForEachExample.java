package lesson8.labs.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {
		
	static Consumer<String> printUpper = e -> System.out.println(e.toUpperCase());
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		list.forEach(consumer);
		printUpcaseList(list);
		printUpcaseList2(list);
		list.forEach(ForEachExample::printUpcase);
	}
	
	 //implement a Consumer 
	static Consumer<String> consumer = new Consumer<String>() {
		@Override
		public void accept(String s) {
			System.out.println(s.toUpperCase());
		}
	};
	
	//a. Use a lambda expression instead of directly defining a Consumer
	public static void printUpcaseList(List<String> list) {
		list.forEach(e -> System.out.println(e.toUpperCase())); 
	}
	
	//b. Use a method reference in place of your lambda expression
	public static void printUpcaseList2(List<String> list) {
		list.forEach(printUpper); 
	}
	
	public static void printUpcase(String s) {
		System.out.println(s.toUpperCase());
	}
}
