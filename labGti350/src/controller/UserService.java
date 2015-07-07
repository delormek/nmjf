/**
 * Author : 
 * Bamb Bakang Tonjé
 * Edited on 21/01/2014
 */
package controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import objects.User;

import org.hibernate.Query;
import org.hibernate.Session;

import entry.Gate;
import util.HibernateUtil;

public class UserService extends Service {

	public HashMap<String, Object> executes(HashMap<String, String> args) {
		load();
		return executes(this.getClass(), args);

	}

	/**
	 * Authentication procedure response for appropriate request
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public HashMap<String, Object> authentication(HashMap<String, Object> argsIn)
			throws SQLException {

		String clis_email = (String) argsIn.get("clis_email");
		String clis_pass = (String) argsIn.get("clis_pass");

		System.out.println("Email : " + clis_email + "\nPassword : "
				+ clis_pass);

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		Query q = session.createQuery(
				"from User where mail_address= :mailaddress").setString(
				"mailaddress", clis_email);

		List<User> result = q.list();
		
		session.close();
		HashMap<String, Object> argsOut = new HashMap<String, Object>();
		if (result.size() == 1) {
			//Get the user 
			User user = result.get(0);
			//Check mail address and password
			if (user.getMailAddress().compareTo(clis_email) == 0
					&& user.getPassword().compareTo(clis_pass) == 0) {

				//save user in an map which will sent to the client
				argsOut.put(User.USER_LBL_IN_SESSION + Gate.SESSION_ATTRIBUTE_SUFFIX, user);
				argsOut.put(Gate.NEW_LOCATION, "/connected/main.jsp");
				//authorization is given
				argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);
				
			} else {
				//the service do not give authorization
				argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);
			}
		}

		
		return argsOut;
	}

	public HashMap<String, Object> getProfile(HashMap<String, Object> args) {

		return (HashMap<String, Object>) null;
	}

	@Override
	public void load() {

		/*
		 * this load available services in this class If a service is not here
		 * then the user won't be able to discover it
		 */
		if (this.servicesList.isEmpty()) {
			this.servicesList.add("authentication");
			// this.servicesList.add("getProfile");
		}

	}
}
