package controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import objects.Group;
import objects.Note;
import objects.SharedNote;
import objects.SharedNoteId;
import objects.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.xml.internal.bind.v2.model.core.ID;

import util.HibernateUtil;
import entry.Gate;

public class UserManageNotesService extends Service {

	public static final String SHARED_NOTES_RECEIVED = "shared_notes_received";
	public static final String SHARED_NOTES_SENT = "shared_notes_sent";
	public static final String SHARED_NOTES_REC_NOT_READ = "shared_notes_rec_not_read";
	public static final String ID_NOTE = "id_note";
	public static final String NB_NOTES_UPDATED = "nb_notes_updated";

	public HashMap<String, Object> executes(HashMap<String, String> args) {
		load();
		return executes(this.getClass(), args);

	}

	public HashMap<String, Object> launchNotesManagement(
			HashMap<String, Object> argsIn) {

		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();

			Transaction tx = session.beginTransaction();

			Query q = session.createQuery(
					"select  u from User u where u.idUser = :idUser ")
					.setParameter("idUser", idUser);

			User u = (User) q.uniqueResult();
			
			tx.commit();
			
			int idGroup = u.getGroup().getIdGroup();

			List<Object> notesNotReadAndAssociateCreators = getNotesNotReadAndAssociateCreators(idGroup,idUser);
			List<Object> AllReceivednotes = getAllReceivedNotes(idGroup,idUser);
			List<Object> AllSentNotes = getAllSentNotes(idUser);

			// save user in an map which will sent to the client
			argsOut.put(UserService.USER_ID + Gate.SESSION_ATTRIBUTE_SUFFIX,
					idUser);

			// save not read notes and associated creator in an map which will
			// sent to the client
			argsOut.put(UserManageNotesService.SHARED_NOTES_REC_NOT_READ
					+ Gate.SESSION_ATTRIBUTE_SUFFIX,
					notesNotReadAndAssociateCreators);

			// save all received notes in an map which will
			// sent to the client
			argsOut.put(UserManageNotesService.SHARED_NOTES_RECEIVED
					+ Gate.SESSION_ATTRIBUTE_SUFFIX, AllReceivednotes);

			// save all sent notes in an map which will
			// sent to the client
			argsOut.put(UserManageNotesService.SHARED_NOTES_SENT
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
						"select n from SharedNote s, Note n where s.user.idUser= :idUser and s.note.idNote= n.idNote")
				.setParameter("idUser", idUser);

		List<Object> sentNotes = (List<Object>) q.list();

		tx.commit();

		return sentNotes;
	}

	private List<Object> getAllReceivedNotes(int idGroup,int idUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session
				.createQuery(
						"select s.note, s.user.FName, s.user.LName from SharedNote s, Note n where s.group.idGroup= :idGroup and s.user.idUser <> :idUser"
						+ " and s.notReadYet=0 and s.note.idNote= n.idNote");
				q.setParameter("idGroup", idGroup);
				q.setParameter("idUser", idUser);

		List<Object> readNotes = (List<Object>) q.list();

		tx.commit();

		return readNotes;
	}

	private List<Object> getNotesNotReadAndAssociateCreators(int idGroup, int idUser) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query q = session
				.createQuery(
						"select s.note, s.user.FName, s.user.LName from SharedNote s, Note n where s.group.idGroup= :idGroup and s.user.idUser <> :idUser"
						+ " and s.notReadYet=1 and s.note.idNote= n.idNote");
				q.setParameter("idGroup", idGroup);
				q.setParameter("idUser", idUser);

		List<Object> notesNotReadAndAssociateCreators = (List<Object>) q.list();

		tx.commit();

		return notesNotReadAndAssociateCreators;
	}

	public HashMap<String, Object> shareNote(HashMap<String, Object> argsIn) {

		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			SharedNote sN = new SharedNote();
			Note n = new Note();
			SharedNoteId sharedNoteid = new SharedNoteId();

			n.setDate(Calendar.getInstance().getTime());

			n.setContent((String) argsIn.get("clis_note"));

			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();

			Transaction tx = session.beginTransaction();

			Query q = session.createQuery(
					"select  u from User u where u.idUser = :idUser ")
					.setParameter("idUser", idUser);

			User u = (User) q.uniqueResult();

			sharedNoteid.setIdGroup(u.getGroup().getIdGroup());
			sharedNoteid.setIdUser(idUser);

			// save the note
			session.save(n);

			sharedNoteid.setIdNote(n.getIdNote());
			sN.setId(sharedNoteid);
			sN.setNotReadYet(1);

			// Share the note with the group
			session.save(sN);

			tx.commit();

			// save user in an map which will sent to the client
			argsOut.put(UserService.USER_ID + Gate.SESSION_ATTRIBUTE_SUFFIX,
					idUser);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/sendNote.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;

	}
	
	
	
	
	public HashMap<String, Object> noteRead ( HashMap<String, Object> argsIn ){
		
		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {
			
			int idNote =Integer.parseInt((String) argsIn.get(UserManageNotesService.ID_NOTE));

			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();

			Transaction tx = session.beginTransaction();

			Query q = session.createQuery("update SharedNote s set s.notReadYet = 0 where"
					+ " s.note.idNote  =:idNote and  s.group.idGroup = ( select"
					+ " u.group.idGroup from User u where u.idUser = :idUser) ");
					q.setParameter("idUser", idUser);
					q.setParameter("idNote", idNote);

			int nbRowsUpdated = q.executeUpdate();

			

			tx.commit();

			// save user in an map which will sent to the client
			argsOut.put(UserService.USER_ID + Gate.SESSION_ATTRIBUTE_SUFFIX,
					idUser);
			
			argsOut.put(UserManageNotesService.NB_NOTES_UPDATED + Gate.SESSION_ATTRIBUTE_SUFFIX,
					nbRowsUpdated);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/menu.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;
	}

	@Override
	public void load() {
		/*
		 * this load available services in this class If a service is not here
		 * then the user won't be able to discover it
		 */
		if (this.servicesList.isEmpty()) {
			this.servicesList.add("launchNotesManagement");
			this.servicesList.add("shareNote");
			this.servicesList.add("noteRead");

		}

	}
}
