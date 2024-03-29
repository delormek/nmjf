package objects;

// Generated Jul 22, 2015 3:20:37 PM by Hibernate Tools 4.3.1

/**
 * OrderedItem generated by hbm2java
 */
public class OrderedItem implements java.io.Serializable {

	private OrderedItemId id;
	private Food food;
	private Order order;
	private int quantity;

	public OrderedItem() {
	}

	public OrderedItem(OrderedItemId id, Food food, Order order, int quantity) {
		this.id = id;
		this.food = food;
		this.order = order;
		this.quantity = quantity;
	}

	public OrderedItemId getId() {
		return this.id;
	}

	public void setId(OrderedItemId id) {
		this.id = id;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
