package edu.usal.factory;

import edu.usal.dao.implementaciones.UpdateLibrosDAOImplementacion;
import edu.usal.dao.interfaces.UpdateLibrosDAO;

public class UpdateLibrosFactory {

	public static UpdateLibrosDAO getFactory() {
		return new UpdateLibrosDAOImplementacion();
	}
}
