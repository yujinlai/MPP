package lesson10.labs.prob6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QueueTest {

	static Queue q = new Queue();
	static List<Thread> list = new ArrayList<Thread>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 10; ++i) {
			list.clear();
			multipleCalls();
			try  
	        {  
	            for (Thread my : list)  
	            {  
	                my.join();  
	            }  
	        }  
	        catch (InterruptedException e)  
	        {  
	            e.printStackTrace();  
	        } 
			System.out.println(q.getCount());
		}		
	}
	
	public static void multipleCalls() {
		Runnable r = () -> {
			for(int i = 0; i < 50; ++i) {
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
		
		for(int i = 0; i < 5; ++i) {
			Thread t = new Thread(r);
			list.add(t);
			t.start();
			
		}

	}

}
