package edu.usal.factory;

import edu.usal.dao.implementaciones.UpdateEditorialesDAOImplementacion;
import edu.usal.dao.interfaces.UpdateEditorialesDAO;

public class UpdateEditorialesFactory {

	public static UpdateEditorialesDAO getFactory() {
		return new UpdateEditorialesDAOImplementacion();
	}
}
