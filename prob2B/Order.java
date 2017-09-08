package prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String orderNum;

	private List<OrderLine> lines = new ArrayList<>();

	public void addOrderLine() {
        OrderLine orderLine = new OrderLine(this);
		lines.add(orderLine);
	}

	// package level
	public Order(String orderNum) {
		this.orderNum = orderNum;
		addOrderLine();
	}

	public List<OrderLine> getOrderLines() {
		return lines;
	}

	@Override
	public String toString() {
		return lines.toString();
	}

	public String getOrderNum() {
		return orderNum;
	}
	
	public int getOrderLineCount() {
		return lines.size();
	}
}
