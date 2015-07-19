/**
 * Author : 
 * Bamb Bakang Tonjé
 * Edited on 21/01/2014
 */
package controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Service implements ILoader {
	// ======================================================================
	/*This resource has to be used in jsp file to specify the name of 
	 * the method which will be executed in the class specified in the 
	 * requested class
	 */
	public static final String REQUESTED_SERVICE_LBL = "service";
	/**
	 * This resource has to be true the label of an argument in the 
	 * returned request when the service has been correctly 
	 * execute and otherwise it is false
	 */
	public static final String SERVICE_VALIDATION_RESPONSE_LBL = "service_response";
	// ======================================================================
	public static final String SESSION_INVALIDATE_BOOL = "session_invalidate_bool";

	// lists of services' names
	protected ArrayList<String> servicesList;

	protected Service() {
		this.servicesList = new ArrayList<String>();
	}

	@SuppressWarnings("unchecked")
	protected HashMap<String, Object> executes(Class<?> serviceClass,
			HashMap<String, String> args) {
		HashMap<String, Object> respMap = new HashMap<String, Object>();
		// validate service existence
		String serviceName = args.get(Service.REQUESTED_SERVICE_LBL);

		if (this.doesServicesExist(serviceName)) {

			@SuppressWarnings("rawtypes")
			Class[] cArg = new Class[1];
			cArg[0] = HashMap.class;
			Method m;

			try {
				m = serviceClass.getMethod(serviceName, cArg);
				respMap = (HashMap<String, Object>) m.invoke(this, args);
			} catch (Exception e) {
				e.printStackTrace();
				// the service failed to make it to the goal . Or you do not have authorization
				respMap.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);
			}
		}
		return respMap;
	}

	protected boolean doesServicesExist(String serviceName) {

		return servicesList.contains(serviceName);
	}

}
