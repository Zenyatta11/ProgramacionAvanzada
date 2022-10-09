package edu.usal.dao.implementaciones;

import edu.usal.dao.interfaces.SessionDAO;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Usuario;
import edu.usal.service.handlers.SessionHandler;

public class SessionDAOImplementacion implements SessionDAO {
	public Usuario checkSession(int sessionID) {
		return new SessionHandler().checkSession(sessionID);
	}

	public ErrorLevel login(String username, String passwd) {
		return new SessionHandler().login(username, passwd);
	}

	public ErrorLevel logout(int sessionID) {
		return new SessionHandler().logout(sessionID);
	}

	public ErrorLevel invalidateSession(int sessionID) {
		return new SessionHandler().invalidateSession(sessionID);
	}
}
