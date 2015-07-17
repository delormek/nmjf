package controller;

import java.util.HashMap;
import java.util.List;

import objects.SharedNote;
import objects.User;
import entry.Gate;

public class UserManageFridgeService extends Service {

	public HashMap<String, Object> executes(HashMap<String, String> args) {
		load();
		return executes(this.getClass(), args);

	}

	public HashMap<String, Object> launchFridgeManagement(
			HashMap<String, Object> argsIn) {

		HashMap<String, Object> argsOut = new HashMap<String, Object>();

		int idUser = -1;
		idUser = Integer.parseInt((String) argsIn.get(UserService.USER_ID
				+ Gate.SESSION_ATTRIBUTE_SUFFIX));

		if (idUser != -1) {

			List<Object> notesNotReadAndAssociateCreators = getGroupFridgeFruitsAndVegetables(idUser);
			List<Object> AllReceivednotes = getGroupFridgeFishAndMeat(idUser);
			List<Object> AllSentNotes = getGroupSideDish(idUser);

			// save user in an map which will sent to the client
			//argsOut.put(User.USER_ID + Gate.SESSION_ATTRIBUTE_SUFFIX, idUser);

			// save not read notes and associated creator in an map which will
			// sent to the client
			//argsOut.put(UserManageNotesService.SHARED_NOTES_REC_NOT_READ
					//+ Gate.SESSION_ATTRIBUTE_SUFFIX,
					//notesNotReadAndAssociateCreators);

			// save all received notes in an map which will
			// sent to the client
			//argsOut.put(SharedNote.SHARED_NOTES_RECEIVED
				///	+ Gate.SESSION_ATTRIBUTE_SUFFIX, AllReceivednotes);

			// save all sent notes in an map which will
			// sent to the client
			//argsOut.put(SharedNote.SHARED_NOTES_SENT
					//+ Gate.SESSION_ATTRIBUTE_SUFFIX, AllSentNotes);

			// give new location to go
			argsOut.put(Gate.NEW_LOCATION, "/connected/ManageNotes.jsp");
			// authorization is given
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

		} else
			argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);

		return argsOut;

	}

	private List<Object> getGroupSideDish(int idUser) {
		
		return null;
	}

	private List<Object> getGroupFridgeFishAndMeat(int idUser) {
		
		return null;
	}

	private List<Object> getGroupFridgeFruitsAndVegetables(int idUser) {
		
		return null;
	}

	@Override
	public void load() {
		//this.servicesList.add("launchFridgeManagement");

	}
}
