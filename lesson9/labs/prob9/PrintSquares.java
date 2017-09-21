package lesson9.labs.prob9;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintSquares {
	public static void printSquares(int num) {
		Stream.iterate(1, n -> (n+1)).limit(num)
			.collect(Collectors.toList()).forEach(n -> System.out.print(n*n + ","));
	}

	public static void main(String[] args) {
		PrintSquares.printSquares(4);
	}
}
