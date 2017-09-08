package lesson5.labs.prob2;

public abstract class Duck {
	public FlyBehavior flyBehavior;
	public QuackBehavior quackBehavior;
	
	public abstract void quack();
	public abstract void fly();
	
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("swimming");
	}
	
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("displaying");
	}
}
