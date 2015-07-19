/**
 * Author : 
 * Bamb Bakang Tonjé
 * Edited on 21/01/2014
 */
package entry;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class Switch {

	/*This resources has to be used in jsp file to specify the name of 
	 * the class which will take care of the client's request.
	 */
	public static final String REQUIRED_CLASSNAME_LBL = "service_type";
	
	/*This is the method a class which inherit from Service has to execute 
	 * DO NOT CHANGE THAT VALUE EVER !*/
	public static final String SERVICE_METHOD_EXECUTES_NAME = "executes";
	private HttpSession session;

	public Switch() {}

	@SuppressWarnings("unchecked")
	public HashMap<String, Object> switchs(HashMap<String, Object> reqParams)
			throws Exception {
		HashMap<String, Object> respMap = new HashMap<String, Object>();
		// redirection on "classname"
		String reqClassName = (String) reqParams.get(REQUIRED_CLASSNAME_LBL);
		if (reqClassName != null) {
			@SuppressWarnings("rawtypes")
			Class t = Class.forName(reqClassName);

			// retrieve method
			@SuppressWarnings("rawtypes")
			Class[] cArg = new Class[1];
			cArg[0] = HashMap.class;
			Method m = t.getDeclaredMethod(SERVICE_METHOD_EXECUTES_NAME, cArg);

			// execute operation
			respMap = (HashMap<String, Object>) m.invoke(t.newInstance(),
					reqParams);
		}

		return respMap;

	}
}
