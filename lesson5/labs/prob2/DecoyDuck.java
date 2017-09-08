package lesson5.labs.prob2;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		// TODO Auto-generated constructor stub
		quackBehavior = new MuteQuack();
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
