package prob2B.extpackage;

import prob2B.Order;

public class Main {
	public static void main(String[] args) {		
		Order order = new Order("000124DF4");
		System.out.println("Order's orderLine: " + order.getOrderLineCount());
		order.addOrderLine();
		order.addOrderLine();
		System.out.println("Order's orderLine: " + order.getOrderLineCount());
		order.addOrderLine();
		System.out.println("Order's orderLine: " + order.getOrderLineCount());
		//not possible to create instance of an OrderLine outside of a Order
		//OrderLine o = new OrderLine(order);
		System.out.println("Order's orderLine: " + order.getOrderLines());
		System.out.println("Order's num: " + order.getOrderNum());
	}

}
