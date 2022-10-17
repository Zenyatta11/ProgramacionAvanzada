package edu.usal.factory;

import edu.usal.dao.implementaciones.UpdateGenerosDAOImplementacion;
import edu.usal.dao.interfaces.UpdateGenerosDAO;

public class UpdateGenerosFactory {

	public static UpdateGenerosDAO getFactory() {
		return new UpdateGenerosDAOImplementacion();
	}
}
