package lesson3.labs.prob3.inheritance;

/*
Does it make sense to use inheritance here? Explain.
No, the reasons are as following:
   Though rigidly binds these classes together, but it's contrary to the LSP principles(Liskov Substitution
   Principle). During execution, the class Circle's area computation method doesn't match the 
   the Cylinder's volume computation method, they are totally different behaviors and don't relate too much. 
*/
public class Circle extends Cylinder {
		
	public Circle(double radius) {
		super(radius, 0);
	}

	public double computeArea() {
	    return pi*getRadius()*getRadius();
	}
}
