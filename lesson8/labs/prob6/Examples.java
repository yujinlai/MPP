package lesson8.labs.prob6;
import java.util.Comparator;
import java.util.function.*;
public class Examples {
	
	
	//type: Class::instanceMethod
	Function<Employee, String> getName1 = (Employee e) -> e.getName();
	Function<Employee, String> getName2 = Employee::getName;
	
	//type:  Class::instanceMethod
	BiConsumer<Employee ,String > setName1 = (Employee e,String s) -> e.setName(s);
	BiConsumer<Employee ,String > setName2 = Employee::setName;
	
	//type: Class::instanceMethod
	Comparator<String> compareTo1 = (String s1,String s2) -> s1.compareTo(s2);
	Comparator<String> compareTo2 = String::compareTo;
	
	//type: Class::staticMethod
	BiFunction<Integer, Integer, Double> pow1 = (Integer x,Integer y) -> Math.pow(x,y);
	BiFunction<Integer, Integer, Double> pow2 = Math::pow;
	
	//type: Class::instanceMethod
	Function<Apple , Double> getWeight1 = (Apple a) -> a.getWeight();
	Function<Apple , Double> getWeight2 = Apple::getWeight;
	
	//type: Class::staticMethod
	Function<String , Integer> parseInt1 = (String x) -> Integer.parseInt(x);
	Function<String , Integer> parseInt2 = Integer::parseInt;
	
	//type: obj::instanceMethod
	EmployeeNameComparator comp = new EmployeeNameComparator();
	Comparator<Employee> compare1 = (Employee e1, Employee e2) -> comp.compare(e1,e2);
	Comparator<Employee> compare2 = comp::compare;
	
	
	public void evaluator() {
		Employee testEmp = new Employee("John", 100000);
		Apple testApple = new Apple(4.5);
		
		//test A
		System.out.println(getName2.apply(testEmp));
		
		//test B
		setName2.accept(testEmp,"Ralph");
		System.out.println(testEmp.getName());
		
		//test C
		System.out.println(compareTo2.compare("a", "b"));
		
		//test D
		System.out.println(pow2.apply(5,3));
		
		//test E
		System.out.println(getWeight2.apply(testApple));
		
		//test F
		System.out.println(parseInt2.apply("15"));
		
		//test G
		System.out.println(compare2.compare(testEmp, new Employee("John", 100000)));
	}
	
	public static void main(String[] args) {
		Examples e = new Examples();
		e.evaluator();
		
	}
	
	 class Apple {
		Apple(double weight) {
			this.weight = weight;
		}
		private double weight;
		public double getWeight() {
			return weight;
		}
	}
}
