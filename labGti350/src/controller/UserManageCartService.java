package controller;

import java.util.HashMap;
import java.util.List;

import objects.Food;
import objects.FoodCategory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entry.Gate;

public class UserManageCartService extends Service {

	public static final String FOOD_CATEGORIES = "food_categories";
	public static final String FOOD = "food";
	public static final String FOOD_CATEGORY_ID = "food_category_id";

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
			argsOut.put(UserManageCartService.FOOD, food);

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

	@Override
	public void load() {
		this.servicesList.add("launchCartManagement");
		this.servicesList.add("displayFoodForCat");
	}
}
