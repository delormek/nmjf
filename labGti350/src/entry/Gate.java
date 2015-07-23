	package entry;

/**
 * Author : 
 * Bamb Bakang Tonjé
 * Edited on 21/01/2014
 */
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Service;

public class Gate extends HttpServlet {

	private static final long serialVersionUID = 6929203834443821471L;
	public static final String CURRENT_LOCATION = "current_location";
	public static final String NEW_LOCATION = "new_location";
	private static final String WELCOME_PAGE_VALUE = "/notConnected/cover.jsp";
	/**
	 * This Charsequence must be part of every session attribute name, it is
	 * needed in order to recognize them as , well, sessions attributes.
	 */
	public static final CharSequence SESSION_ATTRIBUTE_SUFFIX = "_sess";
	private String currentLocation = WELCOME_PAGE_VALUE;

	/**
	 * Allow that servlet to handle POST Request
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {

		HashMap<String, Object> reqParams = getParameters(req);
		String viewpath;

		// if reqParams is empty then it means it a new client
		if (!reqParams.isEmpty()) {

			// if client asking for sign out.
			if (reqParams.containsKey(Service.SESSION_INVALIDATE_BOOL)) {
				Boolean clientSignOut = Boolean.valueOf((String)reqParams
						.get(Service.SESSION_INVALIDATE_BOOL));
				if (clientSignOut) {
					req.getSession().invalidate();
					this.currentLocation = Gate.WELCOME_PAGE_VALUE;
					
					System.out.println("Forwarding to " + req.getContextPath()
							+ this.currentLocation);
					this.getServletContext().getRequestDispatcher(this.currentLocation)
							.forward(req, resp);
					return;
				}
			}

			// get current location
			if ((viewpath = (String) reqParams.get(CURRENT_LOCATION)) != null)
				this.currentLocation = viewpath;

			// call data transmission method, return response
			HashMap<String, Object> respParams = null;
			Switch switcher = new Switch();
			try {
				respParams = switcher.switchs(reqParams);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (Boolean.valueOf((Boolean) respParams
					.get(Service.SERVICE_VALIDATION_RESPONSE_LBL))) {
				req = setParameters(req, respParams);
				this.currentLocation = (String) respParams
						.get(Gate.NEW_LOCATION);
			}

		} else
			this.currentLocation = Gate.WELCOME_PAGE_VALUE;

		System.out.println("Forwarding to " + req.getContextPath()
				+ this.currentLocation);
		this.getServletContext().getRequestDispatcher(this.currentLocation)
				.forward(req, resp);

	}

	/**
	 * Get Requests' parameters and Sessions' Parameters and return them in a
	 * HashMap
	 */
	private HashMap<String, Object> getParameters(HttpServletRequest req) {
		HashMap<String, Object> reqParams = new HashMap<String, Object>();

		// Get parameters values
		Enumeration<String> parametersNames = req.getParameterNames();
		while (parametersNames.hasMoreElements()) {
			String key = parametersNames.nextElement();
			Object value = req.getParameter(key);
			reqParams.put(key, value);
		}

		// Get sessions attributes values
		HttpSession session = req.getSession(true);
		Enumeration<String> sessionsattrNames = session.getAttributeNames();
		while (sessionsattrNames.hasMoreElements()) {
			String key = sessionsattrNames.nextElement();
			Object value = req.getSession().getAttribute(key).toString();
			reqParams.put(key, value);
		}

		System.out.println("Current Session number : "
				+ req.getSession().getId());

		return reqParams;

	}

	private HttpServletRequest setParameters(HttpServletRequest req,
			HashMap<String, Object> respParams) {

		Set<String> keys = respParams.keySet();
		for (String key : keys) {
			if (!key.contains(SESSION_ATTRIBUTE_SUFFIX))
				req.setAttribute(key, respParams.get(key));
			else
				req.getSession().setAttribute(key, respParams.get(key));
		}

		return req;
	}

	/**
	 * Allow that servlet to handle PUT Request ( allow a client to put a file
	 * on a server)
	 */

	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
	}

	/**
	 * Allow that servlet to handle DELETE Request ( allow a client to delete a
	 * file on a server)
	 */
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
	}

	/**
	 * Allow that servlet to handle GET Request
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		doPost(req, resp);
	}

}
