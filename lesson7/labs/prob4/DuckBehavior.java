package lesson7.labs.prob4;

public interface DuckBehavior {
	default void quack() {
		System.out.println(" quacking");
	}
	default void fly() {
		System.out.println(" fly with wings");
	}
	default void swim() {
		System.out.println(" swiming");
	}
	default void display() {
		System.out.println(" displaying");
	}
}
