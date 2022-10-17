package edu.usal.factory;

import edu.usal.dao.implementaciones.ClienteDAOImplementacion;
import edu.usal.dao.interfaces.ClienteDAO;

public class ClienteFactory {

	public static ClienteDAO getFactory() {
		return new ClienteDAOImplementacion();
	}
}
