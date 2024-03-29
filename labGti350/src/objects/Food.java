package objects;

// Generated Jul 22, 2015 3:20:37 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Food generated by hbm2java
 */
public class Food implements java.io.Serializable {

	private Integer id;
	private FoodCategory foodCategory;
	private String name;
	private String nameScientific;
	private String description;
	private String itisId;
	private String wikipediaId;
	private String pictureFileName;
	private String pictureContentType;
	private Integer pictureFileSize;
	private Date pictureUpdatedAt;
	private Integer legacyId;
	private Set orderedItems = new HashSet(0);
	private Set recipeFoods = new HashSet(0);

	public Food() {
	}

	public Food(String name) {
		this.name = name;
	}

	public Food(FoodCategory foodCategory, String name, String nameScientific,
			String description, String itisId, String wikipediaId,
			String pictureFileName, String pictureContentType,
			Integer pictureFileSize, Date pictureUpdatedAt, Integer legacyId,
			Set orderedItems, Set recipeFoods) {
		this.foodCategory = foodCategory;
		this.name = name;
		this.nameScientific = nameScientific;
		this.description = description;
		this.itisId = itisId;
		this.wikipediaId = wikipediaId;
		this.pictureFileName = pictureFileName;
		this.pictureContentType = pictureContentType;
		this.pictureFileSize = pictureFileSize;
		this.pictureUpdatedAt = pictureUpdatedAt;
		this.legacyId = legacyId;
		this.orderedItems = orderedItems;
		this.recipeFoods = recipeFoods;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FoodCategory getFoodCategory() {
		return this.foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameScientific() {
		return this.nameScientific;
	}

	public void setNameScientific(String nameScientific) {
		this.nameScientific = nameScientific;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItisId() {
		return this.itisId;
	}

	public void setItisId(String itisId) {
		this.itisId = itisId;
	}

	public String getWikipediaId() {
		return this.wikipediaId;
	}

	public void setWikipediaId(String wikipediaId) {
		this.wikipediaId = wikipediaId;
	}

	public String getPictureFileName() {
		return this.pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public String getPictureContentType() {
		return this.pictureContentType;
	}

	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}

	public Integer getPictureFileSize() {
		return this.pictureFileSize;
	}

	public void setPictureFileSize(Integer pictureFileSize) {
		this.pictureFileSize = pictureFileSize;
	}

	public Date getPictureUpdatedAt() {
		return this.pictureUpdatedAt;
	}

	public void setPictureUpdatedAt(Date pictureUpdatedAt) {
		this.pictureUpdatedAt = pictureUpdatedAt;
	}

	public Integer getLegacyId() {
		return this.legacyId;
	}

	public void setLegacyId(Integer legacyId) {
		this.legacyId = legacyId;
	}

	public Set getOrderedItems() {
		return this.orderedItems;
	}

	public void setOrderedItems(Set orderedItems) {
		this.orderedItems = orderedItems;
	}

	public Set getRecipeFoods() {
		return this.recipeFoods;
	}

	public void setRecipeFoods(Set recipeFoods) {
		this.recipeFoods = recipeFoods;
	}

}
