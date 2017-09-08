/**
 * 
 */
package lesson4.labs.probC;

/**
 * @author quanyang
 *
 */
public abstract class Employee {
	private String empId;
	
	/**
	 * @param empId
	 */
	public Employee(String empId) {
		this.empId = empId;
	}

	public void print() {
		System.out.print("Employee ID is "+empId+" ,his net is ");
	}
	
	public Paycheck calcCompensation(int month, int year) {
		Paycheck paycheck = 
				new Paycheck(calcGrossPay(month, year), 0.23, 0.05, 0.01, 0.03, 0.075);
		return paycheck;
	}
	
	/**
	 * @param month
	 * @param year
	 * */
	public abstract double calcGrossPay(int month, int year);
}
