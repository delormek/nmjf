package controller;

import java.util.HashMap;

public class UserManageFridgeService extends Service {

	
	public HashMap<String, Object> executes(HashMap<String, String> args) {
		load();
		return executes(this.getClass(), args);

	}
	
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
}
