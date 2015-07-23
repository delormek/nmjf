package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import objects.Food;
import objects.FoodCategory;
import objects.RemainingFood;
import objects.RemainingFoodId;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entry.Gate;

public class UserManageCartService extends Service {

	public static final String FOOD_CATEGORIES = "food_categories";
	public static final String FOOD = "food";
	public static final String FOOD_LIST = "food_list";
	public static final String FOOD_CATEGORY_ID = "food_category_id";
	public static final String FOOD_ID = "food_id";
	public static final String CART_PRODUCT = "cartProduct";

	public HashMap<String, Object> executes(HashMap<String, String> args) {
		load();
		return executes(this.getClass(), args);

	}

	public HashMap<String, Object> launchCartManagement(
			HashMap<String, Object> argsIn) {

		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			List<FoodCategory> categories = getCategories();

			// save list of categories
			argsOut.put(UserManageCartService.FOOD_CATEGORIES, categories);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/ManageCart.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;

	}

	private List<FoodCategory> getCategories() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from FoodCategory");

		List<FoodCategory> categories = (List<FoodCategory>) q.list();

		tx.commit();
		return categories;
	}

	public HashMap<String, Object> displayFoodForCat(
			HashMap<String, Object> argsIn) {

		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			int idCat = -1;
			idCat = Integer.parseInt((String) argsIn
					.get(UserManageCartService.FOOD_CATEGORY_ID));
			List<Food> food = getProductOfCategory(idCat);

			// save list of categories
			argsOut.put(UserManageCartService.FOOD_LIST, food);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/ManageCart.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;

	}

	private List<Food> getProductOfCategory(int idCat) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery(
				"from Food f where f.foodCategory.idFoodCategory = :idCat")
				.setParameter("idCat", idCat);

		List<Food> food = (List<Food>) q.list();

		tx.commit();
		return food;
	}

	public HashMap<String, Object> displayFoodDetails(
			HashMap<String, Object> argsIn) {

		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			int idFood = -1;
			idFood = Integer.parseInt((String) argsIn
					.get(UserManageCartService.FOOD_ID));
			Food food = (Food) getProductFood(idFood);

			// save list of categories
			argsOut.put(UserManageCartService.FOOD, food);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/food_details.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;
	}

	private Food getProductFood(int idFood) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from Food f where f.id= :idFood")
				.setParameter("idFood", idFood);

		Food food = (Food) q.uniqueResult();

		tx.commit();
		return food;
	}

	public HashMap<String, Object> getProducts(HashMap<String, Object> argsIn) {
		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			String productString = "";
			productString = (String) argsIn
					.get(UserManageCartService.CART_PRODUCT);

			String[] str = productString.split(",");

			List<Food> foodlist = (List<Food>) getListFood(str);

			// save list of categories
			argsOut.put(UserManageCartService.FOOD_LIST, foodlist);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/cart_list.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;

	}

	private List<Food> getListFood(String[] str) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q;

		List<Food> listfood = new ArrayList<Food>();
		for (int i = 0; i < str.length; i++) {
			q = session.createQuery("from Food f where f.id="+str[i]);					
			listfood.add((Food) q.uniqueResult());
		}

		tx.commit();
		return listfood;
	}
	
	
	public HashMap<String, Object> order(HashMap<String, Object> argsIn) {
		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			String productString = "";
			productString = (String) argsIn
					.get(UserManageCartService.CART_PRODUCT);

			String[] str = productString.split(",");

			List<Food> foodlist = (List<Food>) getListFood(str);
			
			addFoodInFridge(foodlist,idUser);
			

			// save list of categories
			argsOut.put(UserManageCartService.FOOD_LIST, foodlist);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/fridge_content.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;

	}

	private void addFoodInFridge(List<Food> foodlist, int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q;
		
		q = session.createQuery("select r.idRefrigerator from Refrigerator r, User u where u.idUser=:idUser and r.group.idGroup = u.group.idGroup");
		q.setParameter("idUser",id);
		int idRefrigerator = (int) q.uniqueResult(); 
				
		
		for (int i = 0; i < foodlist.size(); i++) {
			RemainingFood remainingFood = new RemainingFood();
			RemainingFoodId remainingFoodid = new RemainingFoodId(idRefrigerator, foodlist.get(i).getId());
			remainingFood.setId(remainingFoodid);
			session.save(remainingFood);			
		}

		tx.commit();		
	}

	@Override
	public void load() {
		this.servicesList.add("launchCartManagement");
		this.servicesList.add("displayFoodForCat");
		this.servicesList.add("displayFoodDetails");
		this.servicesList.add("getProducts");
		this.servicesList.add("order");
	}
}
