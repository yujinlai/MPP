package lesson5.labs.prob4;

import java.time.LocalDate;

final public class CustOrderFactory {

	public CustOrderFactory() {}

	public static Customer createCustomer (String name) {
		return new Customer(name);
	}
	
	public static Order createOrder (Customer cust, LocalDate date) {
		return Order.newOrder(cust, date);
	}
	
	public static Item createItem (String name) {
		return new Item(name);
	}
}
