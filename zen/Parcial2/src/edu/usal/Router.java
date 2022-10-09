package edu.usal;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.handlers.AuthHandler;
import edu.usal.handlers.LeaseHandler;
import edu.usal.handlers.LoginHandler;
import edu.usal.handlers.RegisterHandler;
import edu.usal.handlers.ViewHandler;
import edu.usal.pages.IndexPage;

public class Router extends HttpServlet {
	private final String rootDirectory = "https://java.batatas.club/ProgramacionAvanzada/zen/Parcial2";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("rootDirectory", this.rootDirectory);
		if(request.getAttribute("currentUser") == null) new AuthHandler(request, response).checkLogin(request, response);

		String action = request.getParameter("action");
		if(action != null) {
			switch(action) {
				case "login": 
				case "logout": new LoginHandler(request, response); break;
				case "register":
				case "registerAdmin": new RegisterHandler(request, response); break;
				case "view": new ViewHandler(request, response); break;
				case "lease": new LeaseHandler(request, response); break;
			}
		}

		new IndexPage(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("rootDirectory", this.rootDirectory);
		new AuthHandler(request, response).checkLogin(request, response);

		String action = request.getParameter("action");
		if(action == null) {
			request.getRequestDispatcher("/WEB-INF/resources/redirect.jsp").include(request, response);
			return;
		}

		switch(action) {
			case "login": 
			case "logout": new LoginHandler(request, response, true); break;
			case "register":
			case "registerAdmin": new RegisterHandler(request, response, true); break;
			case "view": new ViewHandler(request, response, true); break;
			case "lease": new LeaseHandler(request, response, true); break;
		}

		if(request.getParameter("get") != null) doGet(request, response);
	}
}
