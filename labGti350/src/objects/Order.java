package objects;

// Generated Jul 17, 2015 12:09:18 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Order generated by hbm2java
 */
public class Order implements java.io.Serializable {

	private OrderId id;
	private User user;
	private Date dateOrder;
	private Set orderedItems = new HashSet(0);

	public Order() {
	}

	public Order(OrderId id, User user, Date dateOrder) {
		this.id = id;
		this.user = user;
		this.dateOrder = dateOrder;
	}

	public Order(OrderId id, User user, Date dateOrder, Set orderedItems) {
		this.id = id;
		this.user = user;
		this.dateOrder = dateOrder;
		this.orderedItems = orderedItems;
	}

	public OrderId getId() {
		return this.id;
	}

	public void setId(OrderId id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateOrder() {
		return this.dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Set getOrderedItems() {
		return this.orderedItems;
	}

	public void setOrderedItems(Set orderedItems) {
		this.orderedItems = orderedItems;
	}

}
