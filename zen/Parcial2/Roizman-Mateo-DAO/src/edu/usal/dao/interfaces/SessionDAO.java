package edu.usal.dao.interfaces;

import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Usuario;

public interface SessionDAO {
	Usuario checkSession(int sessionID);
	ErrorLevel login(String username, String passwd);
	ErrorLevel logout(int sessionID);
	ErrorLevel invalidateSession(int sessionID);
}
