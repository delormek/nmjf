package objects;

// Generated Jul 17, 2015 12:09:18 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Refrigerator generated by hbm2java
 */
public class Refrigerator implements java.io.Serializable {

	private RefrigeratorId id;
	private Group group;
	private Set remainingFoods = new HashSet(0);

	public Refrigerator() {
	}

	public Refrigerator(RefrigeratorId id, Group group) {
		this.id = id;
		this.group = group;
	}

	public Refrigerator(RefrigeratorId id, Group group, Set remainingFoods) {
		this.id = id;
		this.group = group;
		this.remainingFoods = remainingFoods;
	}

	public RefrigeratorId getId() {
		return this.id;
	}

	public void setId(RefrigeratorId id) {
		this.id = id;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Set getRemainingFoods() {
		return this.remainingFoods;
	}

	public void setRemainingFoods(Set remainingFoods) {
		this.remainingFoods = remainingFoods;
	}

}
