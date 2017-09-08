/**
 * 
 */
package lesson4.labs.probC;

/**
 * @author quanyang
 *
 */
public class Salaried extends Employee {
	private double salary;

	/**
	 * @param empId
	 * @param salary
	 */
	public Salaried(String empId, double salary) {
		super(empId);
		this.salary = salary;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/* (non-Javadoc)
	 * @see lesson4.labs.probC.Employee#calcGrossPay(int, int)
	 */
	@Override
	public double calcGrossPay(int month, int year) {
		// TODO Auto-generated method stub
		double gp = salary;
		System.out.println("The Gross Pay in the month of "+month+", "+year+" is "+gp);
		return gp;
	}

}
