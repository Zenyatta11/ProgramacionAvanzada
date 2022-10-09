package edu.usal.factory;

import edu.usal.dao.implementaciones.GenerosDAOImplementacion;
import edu.usal.dao.interfaces.GenerosDAO;

public class GenerosFactory {

	public static GenerosDAO getFactory() {
		return new GenerosDAOImplementacion();
	}
}
