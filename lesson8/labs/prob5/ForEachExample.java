package lesson8.labs.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//original lesson 7 method
		list.forEach(consumer);
		//Use a lambda expression instead of directly defining a Consumer
		list.forEach(e -> System.out.println(e.toUpperCase())); 
		//Use a method reference in place of your lambda expression
		list.forEach(ForEachExample::printUpcase);
	}
	
	 //implement a Consumer
	static Consumer<String> consumer = new Consumer<String>() {
		@Override
		public void accept(String s) {
			System.out.println(s.toUpperCase());
		}
	};
	
	public static void printUpcase(String s) {
		System.out.println(s.toUpperCase());
	}
	
}
