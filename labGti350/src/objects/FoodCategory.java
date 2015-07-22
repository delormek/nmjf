package objects;

// Generated Jul 22, 2015 3:20:37 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * FoodCategory generated by hbm2java
 */
public class FoodCategory implements java.io.Serializable {

	private Integer idFoodCategory;
	private String name;
	private Set foods = new HashSet(0);

	public FoodCategory() {
	}

	public FoodCategory(String name) {
		this.name = name;
	}

	public FoodCategory(String name, Set foods) {
		this.name = name;
		this.foods = foods;
	}

	public Integer getIdFoodCategory() {
		return this.idFoodCategory;
	}

	public void setIdFoodCategory(Integer idFoodCategory) {
		this.idFoodCategory = idFoodCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getFoods() {
		return this.foods;
	}

	public void setFoods(Set foods) {
		this.foods = foods;
	}

}
