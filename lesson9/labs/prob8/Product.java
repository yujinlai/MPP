package lesson9.labs.prob8;

import java.util.Optional;

public class Product {
	private String productId;
	private Optional<String> productName;
	private double unitPrice;
	public Product(String prodId, Optional<String> prodName, double price) {
		this.productId = prodId;
		this.productName = prodName;
		this.unitPrice = price;
	}
	public String getProductId() {
		return productId;
	}
	public Optional<String> getProductName() {
		return productName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
}
