package lesson9.labs.prob8;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	List<OrderItem> orderItems = new ArrayList<>();
	public static void main(String[] args) {
		Main m = new Main();
		m.loadOrderItemData();
		System.out.println("Do any of these Order Items have an order of flowers? " +
		   m.findProduct("Flowers"));
	}

	private boolean findProduct(String prodName) {
		List<Optional<OrderItem>> orderItemList =
				orderItems.stream()
			            .map(Optional::ofNullable)
			            .collect(Collectors.toList());
		for(Optional<OrderItem> item:orderItemList){
			if(item.flatMap(x -> x.getProduct())
					.flatMap(x -> x.getProductName())
					.orElse("").equals(prodName)){
				return true;
			}
		}
		return false;
	}

	private void loadOrderItemData() {
		orderItems.add(new OrderItem(Optional.of(new Product("1016", Optional.of("Tools"), 131.00)), 3));
		orderItems.add(new OrderItem(Optional.of(new Product("1017", Optional.of("Fishing Rod"), 111.00)), 1));
		orderItems.add(new OrderItem(Optional.of(new Product("1018", Optional.of("Game of Go"),66.00)), 2));
		orderItems.add(new OrderItem(Optional.of(new Product("1019", Optional.of("Flowers"), 221.00)), 5));
	}
}
