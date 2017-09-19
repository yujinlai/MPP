package lesson7.labs.prob4;

public class Main {

	public static void main(String[] args) {
		DuckBehavior[] ducks = 
			{new MallardDuck(), new DecoyDuck(), new RedheadDuck(), new RubberDuck()};
		for (DuckBehavior d : ducks) {
			System.out.println(d.getClass().getSimpleName() + ":");
			d.display();
			d.fly();
			d.quack();
			d.swim();
		}
	}
}
