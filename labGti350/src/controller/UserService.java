/**
 * Author : 
 * Bamb Bakang Tonjé
 * Edited on 21/01/2014
 */
package controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import objects.SharedNote;
import objects.SharedNoteId;
import objects.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entry.Gate;

public class UserService extends Service {

	private static final String NB_SHARED_NOTES_REC = "nb_shared_notes_rec";
	private static final String USER_NAME_STYLE1 = "user_name_style1";
	static final String USER_ID = "user_id";

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

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery(
				"from User where mail_address= :mailaddress ").setString(
				"mailaddress", clis_email);

		User user = (User) q.uniqueResult();

		tx.commit();

		HashMap<String, Object> argsOut = new HashMap<String, Object>();
		if (user != null) {

			// Check mail address and password
			if (user.getMailAddress().compareTo(clis_email) == 0
					&& user.getPassword().compareTo(clis_pass) == 0) {

				Session session1 = HibernateUtil.getSessionFactory()
						.getCurrentSession();

				Transaction tx1 = session1.beginTransaction();

				q = session1
						.createQuery(
								"select s.note, s.userByIdUserCre from SharedNote s, Note n where s.id.idUserRec= :idUser and s.notReadYet=1 and s.id.idNote=n.idNote")
						.setParameter("idUser", user.getId());

				List<Object> notesAndUserCre = (List<Object>) q.list();

				int nbNotesNotRead = notesAndUserCre.size();

				tx1.commit();

				// save user in an map which will sent to the client

				argsOut.put(UserService.USER_ID + Gate.SESSION_ATTRIBUTE_SUFFIX,
						user.getId());

				String userName = user.getFName() + " "
						+ user.getLName().charAt(0) + ".";
				argsOut.put(UserService.USER_NAME_STYLE1
						+ Gate.SESSION_ATTRIBUTE_SUFFIX, userName);

				// save notes in an map which will sent to the client
				argsOut.put(UserService.NB_SHARED_NOTES_REC
						+ Gate.SESSION_ATTRIBUTE_SUFFIX, nbNotesNotRead);

				// give new location to go
				argsOut.put(Gate.NEW_LOCATION, "/connected/menu.jsp");
				// authorization is given
				argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

			} else {
				// the service do not give authorization
				argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);
			}
		}
		return argsOut;
	}

	@Override
	public void load() {

		/*
		 * this load available services in this class If a service is not here
		 * then the user won't be able to discover it
		 */
		if (this.servicesList.isEmpty()) {
			this.servicesList.add("authentication");
		}

	}
}
