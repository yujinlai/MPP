package lesson5.labs.prob2;

public class RubberDuck extends Duck {

	public RubberDuck() {
		// TODO Auto-generated constructor stub
		quackBehavior = new Squeak();
		flyBehavior = new CannotFly();
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		quackBehavior.quack();
	}

	@Override
	public void fly() {
		flyBehavior.fly();
	}
}
