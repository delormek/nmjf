package objects;

// Generated Jul 22, 2015 3:20:37 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Recipe generated by hbm2java
 */
public class Recipe implements java.io.Serializable {

	private Integer id;
	private String name;
	private String description;
	private Set recipeFoods = new HashSet(0);

	public Recipe() {
	}

	public Recipe(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Recipe(String name, String description, Set recipeFoods) {
		this.name = name;
		this.description = description;
		this.recipeFoods = recipeFoods;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getRecipeFoods() {
		return this.recipeFoods;
	}

	public void setRecipeFoods(Set recipeFoods) {
		this.recipeFoods = recipeFoods;
	}

}
