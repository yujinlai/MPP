package lesson9.labs.prob8;

import java.util.Optional;

public class OrderItem {
	private Optional<Product> product;
	private int quantityRequested;
	private double totalPrice;
	//package level constructor
	OrderItem(Optional<Product> product, int quantity) {
		this.product = product;
		this.quantityRequested = quantity;
		totalPrice = product.get().getUnitPrice() * quantity;
	}
	@Override
	public String toString() {
		return "   " + product.get().getProductId() + ": " + quantityRequested + ", " + product.get().getUnitPrice();
	}
	public Optional<Product> getProduct() {
		return product;
	}
	public int getQuantityRequested() {
		return quantityRequested;
	}
	public double getTotalPrice() {
		return totalPrice;
	}

}
