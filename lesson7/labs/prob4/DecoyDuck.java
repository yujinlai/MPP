package lesson7.labs.prob4;

public class DecoyDuck implements DuckBehavior {
	@Override
	public void fly() {
		System.out.println(" cannot fly");
	}
	@Override
	public void quack() {
		System.out.println(" cannot quack");
	}
}
