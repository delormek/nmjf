package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import objects.Food;
import objects.Recipe;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entry.Gate;

public class UserManageRecipeService extends Service {

	public static final String RECIPE_LIST = "recipe_list";
	public static final String RECIPE_ID = "recipe_id";
	public static final String RECIPE = "recipe";
	public HashMap<String, Object> executes(HashMap<String, String> args) {
		load();
		return executes(this.getClass(), args);

	}

	public HashMap<String, Object> launchRecipesManagement(
			HashMap<String, Object> argsIn) {
		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			List<Recipe> recipelist = (List<Recipe>) getRecipeList(idUser);

			// save list of categories
			argsOut.put(UserManageRecipeService.RECIPE_LIST, recipelist);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/recipe_list.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;

	}

	private List<Recipe> getRecipeList(int idUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q;

		// get user 's refrigerator's id
		q = session
				.createQuery("select r.idRefrigerator from Refrigerator r, User u where u.idUser=:idUser and r.group.idGroup = u.group.idGroup");
		q.setParameter("idUser", idUser);
		Integer idRefrigerator = (Integer) q.uniqueResult();

		// get content of the fridge
		q = session
				.createQuery(
						" select f.id from RemainingFood r, Food f where r.refrigerator.idRefrigerator = :idRefrige and "
								+ "r.id.idFood = f.id ").setParameter(
						"idRefrige", idRefrigerator);

		List<Integer> foodlist = (List<Integer>) q.list();

		List<Recipe> recipes = new ArrayList<Recipe>();
		for (int i = 0; i < foodlist.size(); i++) {
			q = session
					.createQuery(
							"select r from Recipe r, RecipeFood rf where rf.food.id = :foodId group by(r)")
					.setParameter("foodId", foodlist.get(i));		
			
			recipes.addAll(((List<Recipe>)q.list()));
			
		}
		
		tx.commit();
		
		for (int i = 0; i < recipes.size(); i++) {
			for (int j = 1; j < recipes.size(); j++) {
				if(recipes.get(i).getName().compareTo(recipes.get(j).getName())==0)
					recipes.remove(j);
			}
		}

		return recipes;
	}
	
	
	public HashMap<String, Object> displayRecipeDetails(
			HashMap<String, Object> argsIn) {

		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			int idRecipe = -1;
			idRecipe = Integer.parseInt((String) argsIn
					.get(UserManageRecipeService.RECIPE_ID));
			Recipe recipe = (Recipe) getRecipe(idRecipe);

			// save list of categories
			argsOut.put(UserManageRecipeService.RECIPE, recipe);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/recipe_details.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;
	}

	private Recipe getRecipe(int idRecipe) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from Recipe f where f.id= :idRecipe")
				.setParameter("idRecipe", idRecipe);

		Recipe recipe = (Recipe) q.uniqueResult();

		tx.commit();
		return recipe;
	}

	@Override
	public void load() {
		this.servicesList.add("launchRecipesManagement");
		this.servicesList.add("displayRecipeDetails");

	}
}
