package lesson5.labs.prob2;

public class RedheadDuck extends Duck {

	public RedheadDuck() {
		// TODO Auto-generated constructor stub
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
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
