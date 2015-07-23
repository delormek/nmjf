package controller;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entry.Gate;
import objects.Food;
import objects.RemainingFood;
import objects.RemainingFoodId;
import objects.SharedNote;
import objects.User;
import util.HibernateUtil;

public class UserManageFridgeService extends Service {

	public HashMap<String, Object> executes(HashMap<String, String> args) {
		load();
		return executes(this.getClass(), args);

	}

	public HashMap<String, Object> launchFridgeManagement(HashMap<String, Object> argsIn) {
		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			
			List<Food> foodlist = (List<Food>) getListFoodGroup(idUser);

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

	private List<Food> getListFoodGroup(int idUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q;

		q = session
				.createQuery("select r.idRefrigerator from Refrigerator r, User u where u.idUser=:idUser and r.group.idGroup = u.group.idGroup");
		q.setParameter("idUser", idUser);
		Integer idRefrigerator = (Integer) q.uniqueResult();
		
		q = session.createQuery(" select f from RemainingFood r, Food f where r.refrigerator.idRefrigerator = :idRefrige and "
				+ "r.id.idFood = f.id ").setParameter("idRefrige", idRefrigerator);

		List<Food> foodlist = (List<Food>) q.list();
	
		tx.commit();
		
		return foodlist;
	}

	
	@Override
	public void load() {
		this.servicesList.add("launchFridgeManagement");

	}
}
