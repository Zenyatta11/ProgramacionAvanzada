package edu.usal.factory;

import edu.usal.dao.implementaciones.EditorialesDAOImplementacion;
import edu.usal.dao.interfaces.EditorialesDAO;

public class EditorialesFactory {

	public static EditorialesDAO getFactory() {
		return new EditorialesDAOImplementacion();
	}
}
