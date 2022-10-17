package edu.usal.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import edu.usal.factory.SessionFactory;
import edu.usal.dao.interfaces.SessionDAO;

public class AuthHandler {
	private final String sessionKey;

	public AuthHandler(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie cookies[]=request.getCookies();
		String key = null;

		if(cookies != null) {
			for(int i=0; i < cookies.length; i = i + 1){  
				if(cookies[i].getName().equals("session")) {
					key = cookies[i].getValue();
					break;
				}
			}
		}
		
		this.sessionKey = key;
	}

	public void checkLogin(HttpServletRequest request, HttpServletResponse response) {
		SessionDAO Factory = SessionFactory.getFactory();
		
		if(this.sessionKey == null) request.setAttribute("currentUser", null);
		else request.setAttribute("currentUser", Factory.checkSession(Integer.valueOf(this.sessionKey)));
	}

	public String getSessionID() {
		return this.sessionKey;
	}
}
