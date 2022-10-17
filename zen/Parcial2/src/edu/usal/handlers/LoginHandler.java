package edu.usal.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Usuario;

import edu.usal.factory.SessionFactory;
import edu.usal.dao.interfaces.SessionDAO;

public class LoginHandler {

	public LoginHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch(action) {
			case "login": handleLoginGET(request, response); break;
			case "logout": handleLogout(request, response); break;
		}
		
	}

	private void handleLoginGET(HttpServletRequest request, HttpServletResponse response) {
		Usuario currentUser = (Usuario)request.getAttribute("currentUser");

		if(currentUser != null) request.setAttribute("content", "home.jsp");
		else request.setAttribute("content", "login.jsp");
	}

	public LoginHandler(HttpServletRequest request, HttpServletResponse response, boolean processPOST) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch(action) {
			case "login": handleLoginPOST(request, response); break;
			case "logout": handleLogout(request, response); break;
		}
	}

	private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sessionID = new AuthHandler(request, response).getSessionID();
		if(sessionID == null) {
			// no estamos loggueados, que hacemos aca?
			request.setAttribute("redirect", "/");
			request.getRequestDispatcher("/WEB-INF/resources/redirect.jsp").include(request, response);
			return;
		}

		SessionDAO Factory = SessionFactory.getFactory();
		ErrorLevel errorLevel = Factory.logout(Integer.valueOf(sessionID));

		if(errorLevel.isError()) {
			request.setAttribute("content", "login.jsp");
			request.setAttribute("errorText", errorLevel.getPayload());
		} else {
			Cookie cookie = new Cookie("session", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);

			request.setAttribute("redirect", "/");
			request.getRequestDispatcher("/WEB-INF/resources/redirect.jsp").include(request, response);
		}
	}

	private void handleLoginPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getAttribute("currentUser") != null) {
			// ya estamos loggueados, que hacemos aca?
			request.setAttribute("redirect", "/");
			request.getRequestDispatcher("/WEB-INF/resources/redirect.jsp").include(request, response);
			return;
		}

		String username = request.getParameter("p_username");
		String passwd = request.getParameter("p_passwd");

		if(username == null || passwd == null) {
			request.setAttribute("content", "login.jsp");
			return;
		}

		SessionDAO Factory = SessionFactory.getFactory();
		ErrorLevel errorLevel = Factory.login(username, passwd);

		if(errorLevel.isError()) {
			request.setAttribute("content", "login.jsp");
			request.setAttribute("errorText", errorLevel.getPayload());
		} else {
			Cookie cookie = new Cookie("session", errorLevel.getPayload());

			// me pudren las paginas que me hacen logguearme cada 5 minutos
			// te estoy mirando a vos, Blackboard...
			cookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(cookie);

			request.setAttribute("redirect", errorLevel.getRedirect());
			request.getRequestDispatcher("/WEB-INF/resources/redirect.jsp").include(request, response);
		}
	}
}
