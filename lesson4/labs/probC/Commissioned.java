/**
 * 
 */
package lesson4.labs.probC;

import java.util.ArrayList;

/**
 * @author quanyang
 *
 */
public class Commissioned extends Employee {
	private double commission;
	private double baseSalary;
	private ArrayList<Order> orders = new ArrayList<>();

	/**
	 * @param empId
	 * @param commission
	 * @param baseSalary
	 */
	public Commissioned(String empId, double commission, double baseSalary) {
		super(empId);
		this.commission = commission;
		this.baseSalary = baseSalary;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}
	/**
	 * @return the commission
	 */
	public double getCommission() {
		return commission;
	}

	/**
	 * @param commission the commission to set
	 */
	public void setCommission(double commission) {
		this.commission = commission;
	}

	/**
	 * @return the baseSalary
	 */
	public double getBaseSalary() {
		return baseSalary;
	}

	/**
	 * @param baseSalary the baseSalary to set
	 */
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	/**
	 * @return the orders
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	/* (non-Javadoc)
	 * @see lesson4.labs.probC.Employee#calcGrossPay(int, int)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public double calcGrossPay(int month, int year) {
		// TODO Auto-generated method stub
		int orderAmountSum = 0;
		for (Order order : orders) {
			if (order.getOrderDate().getYear()==year && 
					order.getOrderDate().getMonth()==month-1) {
				orderAmountSum += order.getOrderAmount();
			}
		}
		double gp = baseSalary + commission*orderAmountSum;
		System.out.println("The Gross Pay in the month of "+month+", "+year+" is "+gp);
		return gp;
	}

}
