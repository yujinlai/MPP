/**
 * 
 */
package lesson4.labs.probC;

/**
 * @author quanyang
 *
 */
public class Hourly extends Employee {
	private double hourlyWage;
	private int hoursPerWeek;
	
	/**
	 * @param empId
	 * @param hourlyWage
	 * @param hoursPerWeek
	 */
	public Hourly(String empId, double hourlyWage, int hoursPerWeek) {
		super(empId);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}

	/**
	 * @return the hourlyWage
	 */
	public double getHourlyWage() {
		return hourlyWage;
	}

	/**
	 * @param hourlyWage the hourlyWage to set
	 */
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	/**
	 * @return the hoursPerWeek
	 */
	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	/**
	 * @param hoursPerWeek the hoursPerWeek to set
	 */
	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	/* (non-Javadoc)
	 * @see lesson4.labs.probC.Employee#calcGrossPay(int, int)
	 */
	@Override
	public double calcGrossPay(int month, int year) {
		// TODO Auto-generated method stub
		double gp = hourlyWage*hoursPerWeek*4;
		System.out.println("The Gross Pay in the month of "+month+", "+year+" is "+gp);
		return gp;
	}

}
