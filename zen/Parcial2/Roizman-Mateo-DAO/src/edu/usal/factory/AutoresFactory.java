package edu.usal.factory;

import edu.usal.dao.implementaciones.AutoresDAOImplementacion;
import edu.usal.dao.interfaces.AutoresDAO;

public class AutoresFactory {

	public static AutoresDAO getFactory() {
		return new AutoresDAOImplementacion();
	}
}
