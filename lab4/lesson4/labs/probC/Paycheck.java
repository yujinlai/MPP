/**
 * 
 */
package lesson4.labs.probC;

/**
 * @author quanyang
 *
 */
public final class Paycheck {
	private double grossPay;
	private double fica;
	private double state;
	private double local;
	private double medicare;
	private double socialSecurity;
	/**
	 * @param grossPay
	 * @param fica
	 * @param state
	 * @param local
	 * @param medicare
	 * @param socialSecurity
	 */
	public Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
		this.grossPay = grossPay;
		this.fica = fica;
		this.state = state;
		this.local = local;
		this.medicare = medicare;
		this.socialSecurity = socialSecurity;
	}
	
	public double getNetPay() {
		return grossPay*(1-fica-state-local-medicare-socialSecurity);
	}
	
	public void print() {
		System.out.println("Gross Pay is "+grossPay+" and Net Pay is "+getNetPay());
	}
}
