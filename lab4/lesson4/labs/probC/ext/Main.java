/**
 * 
 */
package lesson4.labs.probC.ext;

import lesson4.labs.probC.*;

/**
 * @author quanyang
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee1 = new Hourly("H01",9.5,20);
		Employee employee2 = new Salaried("S01",3000);
		Employee employee3 = new Commissioned("C01",100,1000);
		double netPay1 = employee1.calcCompensation(6, 2016).getNetPay();
		double netPay2 = employee2.calcCompensation(6, 2016).getNetPay();
		double netPay3 = employee3.calcCompensation(6, 2016).getNetPay();
		employee1.print();
		System.out.println(netPay1);
		employee2.print();
		System.out.println(netPay2);
		employee3.print();
		System.out.println(netPay3);
	}

}
