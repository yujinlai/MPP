package lesson10.labs.prob6;

import java.util.concurrent.TimeUnit;

public class QueueThreadsafeTest {

	static QueueThreadSafe q = new QueueThreadSafe();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; ++i) {
			multipleCalls();
			
		}	
	}
	
	public static void multipleCalls() {
		Runnable r = () -> {
			for(int i = 0; i < 500; ++i) {
				q.add("888");
				
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				q.remove();
			}
		};
		
		for(int i = 0; i < 1000; ++i) {
			new Thread(r).start();
			
		}

	}

}
