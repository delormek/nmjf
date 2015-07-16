package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import objects.SharedNote;
import objects.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entry.Gate;

public class UserManageNotesService extends Service {

	public HashMap<String, Object> executes(HashMap<String, String> args) {
		load();
		return executes(this.getClass(), args);

	}

	public HashMap<String, Object> launchNotesManagement(
			HashMap<String, Object> argsIn) {

		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(User.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			List<Object> notesNotReadAndAssociateCreators = getNotesNotReadAndAssociateCreators(idUser);
			List<Object> AllReceivednotes = getAllReceivedNotes(idUser);
			List<Object> AllSentNotes = getAllSentNotes(idUser);

			// save user in an map which will sent to the client
			argsOut.put(User.USER_ID + Gate.SESSION_ATTRIBUTE_SUFFIX, idUser);

			// save not read notes and associated creator in an map which will
			// sent to the client
			argsOut.put(SharedNote.SHARED_NOTES_REC_NOT_READ
					+ Gate.SESSION_ATTRIBUTE_SUFFIX,
					notesNotReadAndAssociateCreators);

			// save all received notes in an map which will
			// sent to the client
			argsOut.put(SharedNote.SHARED_NOTES_RECEIVED
					+ Gate.SESSION_ATTRIBUTE_SUFFIX, AllReceivednotes);

			// save all sent notes in an map which will
			// sent to the client
			argsOut.put(SharedNote.SHARED_NOTES_SENT
					+ Gate.SESSION_ATTRIBUTE_SUFFIX, AllSentNotes);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/ManageNotes.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;
	}

	private List<Object> getAllSentNotes(int idUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session
				.createQuery(
						"select s.note from SharedNote s, Note n where s.id.idUserCre= :idUser and s.id.idNote=n.idNote")
				.setParameter("idUser", idUser);

		List<Object> sentNotes = (List<Object>) q.list();

		tx.commit();

		return sentNotes;
	}

	private List<Object> getAllReceivedNotes(int idUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session
				.createQuery(
						"select s.note from SharedNote s, Note n where s.id.idUserRec= :idUser and s.notReadYet=0 and s.id.idNote=n.idNote")
				.setParameter("idUser", idUser);

		List<Object> readNotes = (List<Object>) q.list();

		tx.commit();		

		return readNotes;
	}

	private List<Object> getNotesNotReadAndAssociateCreators(int idUser) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session
				.createQuery(
						"select s.note, s.userByIdUserCre from SharedNote s, Note n where s.id.idUserRec= :idUser and s.notReadYet=1 and s.id.idNote=n.idNote")
				.setParameter("idUser", idUser);

		List<Object> notesNotReadAndAssociateCreators = (List<Object>) q.list();

		tx.commit();		

		return notesNotReadAndAssociateCreators;
	}

	@Override
	public void load() {
		/*
		 * this load available services in this class If a service is not here
		 * then the user won't be able to discover it
		 */
		if (this.servicesList.isEmpty()) {
			this.servicesList.add("launchNotesManagement");

		}

	}
}
