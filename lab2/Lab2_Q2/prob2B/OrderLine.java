package prob2B;

public class OrderLine {
	// package level
	private Order order;

	OrderLine(Order order) {
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
}
