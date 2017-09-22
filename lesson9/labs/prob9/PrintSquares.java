package lesson9.labs.prob9;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintSquares {
	public static void printSquares(int num) {
		IntStream.iterate(1, n -> (int)Math.pow((Math.sqrt(n) + 1), 2)).limit(num)
				.boxed().collect(Collectors.toList()).forEach(n -> System.out.print(n + ","));
	}

	public static void main(String[] args) {
		PrintSquares.printSquares(4);
	}
}
