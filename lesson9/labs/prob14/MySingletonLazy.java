package lesson9.labs.prob14;

import java.util.Optional;

public class MySingletonLazy {

	private static MySingletonLazy instance = null;
	private MySingletonLazy() {}
	public static MySingletonLazy getInstance() {
			//if(instance == null) {
			//	instance = new MySingletonLazy();
			//}
			//return instance;
			return Optional.ofNullable(instance).orElse(new MySingletonLazy());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MySingletonLazy inst = getInstance();
		System.out.println(inst.toString());
	}

}
