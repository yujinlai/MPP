package lesson9.labs.prob4;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class PrimeStream {
	
	final Stream<Integer> primes = Stream.iterate(2, i -> i + 1)
            .filter(x -> isPrime(x));
	
	final Supplier<Stream<Integer>> streamSupplier = ()->Stream.iterate(2, i -> i + 1)
            .filter(x -> isPrime(x));
	
	
	public boolean isPrime(int n) {
		if(n == 2) return true;
		for(int i=2; i<Math.sqrt(n)+1; i++)
			if(n%i == 0)
				return false;
		return true;
	}
	
	public void printFirstNPrimes(int n) {
		streamSupplier.get().limit(n).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		PrimeStream ps = new PrimeStream(); // PrimeStream is enclosing class
		ps.printFirstNPrimes(10);
		System.out.println("====");
		ps.printFirstNPrimes(5);
	}

}
