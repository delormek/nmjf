package objects;

// Generated Jul 17, 2015 7:51:51 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Group generated by hbm2java
 */
public class Group implements java.io.Serializable {

	private int idGroup;
	private String name;
	private Set refrigerators = new HashSet(0);
	private Set sharedNotes = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set users = new HashSet(0);

	public Group() {
	}

	public Group(int idGroup) {
		this.idGroup = idGroup;
	}

	public Group(int idGroup, String name, Set refrigerators, Set sharedNotes,
			Set orders, Set users) {
		this.idGroup = idGroup;
		this.name = name;
		this.refrigerators = refrigerators;
		this.sharedNotes = sharedNotes;
		this.orders = orders;
		this.users = users;
	}

	public int getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getRefrigerators() {
		return this.refrigerators;
	}

	public void setRefrigerators(Set refrigerators) {
		this.refrigerators = refrigerators;
	}

	public Set getSharedNotes() {
		return this.sharedNotes;
	}

	public void setSharedNotes(Set sharedNotes) {
		this.sharedNotes = sharedNotes;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}