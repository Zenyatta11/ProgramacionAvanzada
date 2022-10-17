package edu.usal.factory;

import edu.usal.dao.implementaciones.UpdateAutoresDAOImplementacion;
import edu.usal.dao.interfaces.UpdateAutoresDAO;

public class UpdateAutoresFactory {

	public static UpdateAutoresDAO getFactory() {
		return new UpdateAutoresDAOImplementacion();
	}
}
