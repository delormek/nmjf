package objects;

// Generated Jul 8, 2015 3:09:09 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Order generated by hbm2java
 */
public class Order implements java.io.Serializable {

	private int idOrder;
	private User user;
	private Date dateOrder;
	private Set orderedItems = new HashSet(0);

	public Order() {
	}

	public Order(int idOrder, User user, Date dateOrder) {
		this.idOrder = idOrder;
		this.user = user;
		this.dateOrder = dateOrder;
	}

	public Order(int idOrder, User user, Date dateOrder, Set orderedItems) {
		this.idOrder = idOrder;
		this.user = user;
		this.dateOrder = dateOrder;
		this.orderedItems = orderedItems;
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
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
