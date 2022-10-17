package edu.usal.factory;

import edu.usal.dao.implementaciones.SessionDAOImplementacion;
import edu.usal.dao.interfaces.SessionDAO;

public class SessionFactory {

	public static SessionDAO getFactory() {
		return new SessionDAOImplementacion();
	}
}
