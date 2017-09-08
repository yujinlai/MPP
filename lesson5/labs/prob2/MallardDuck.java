package lesson5.labs.prob2;

public class MallardDuck extends Duck {

	public MallardDuck() {
		// TODO Auto-generated constructor stub
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
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
