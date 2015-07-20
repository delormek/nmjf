package controller;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entry.Gate;

public class UserManageCartService extends Service {

	public static final String FOOD_CATEGORIES = "food_categories";

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

			List<String> categories = getCategories();

			// save list of categories
			argsOut.put(UserManageCartService.FOOD_CATEGORIES
					+ Gate.SESSION_ATTRIBUTE_SUFFIX, categories);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/ManageCart.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;

	}

	private List<String> getCategories() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("select name from FoodCategory");

		List<String> categories = (List<String>) q.list();

		tx.commit();
		return categories;
	}

	@Override
	public void load() {
		this.servicesList.add("launchCartManagement");

	}
}
