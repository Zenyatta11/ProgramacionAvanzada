package edu.usal;

import javax.servlet.http.HttpServlet;

import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Usuario;
import edu.usal.factory.SessionFactory;
import edu.usal.dao.interfaces.SessionDAO;

public class LoginPage extends HttpServlet {
	public LoginPage() {
		SessionDAO Factory = SessionFactory.getFactory();
		
		String retVal = "";
		retVal = retVal + Stringify(Factory.login("Mateo", "41316822"));
		retVal = retVal + Stringify(Factory.checkSession(22));
	}

	private String Stringify(ErrorLevel e) {
		return "[" + (e.isError() ? "Error" : "Info") + "|" + e.getPayload() + "|" + e.getRedirect() + "]";
	}

	private String Stringify(Usuario e) {
		return "[" + 
			e.getDNI() + "|" + 
			e.getNombre() + "|" + 
			e.getApellido() + "|" + 
			e.getTelefono() + "|" + 
			e.getEmail() + "|" + 
			e.getEmail() + "|" + 
			(e.isAdmin() ? "Admin" : "User" ) + "|" + 
			(e.isUser() ? "User" : "Admin" ) + "]";
	}
}
