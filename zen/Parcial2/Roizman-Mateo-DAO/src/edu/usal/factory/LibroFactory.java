package edu.usal.factory;

import edu.usal.dao.implementaciones.LibrosDAOImplementacion;
import edu.usal.dao.interfaces.LibrosDAO;

public class LibroFactory {

	public static LibrosDAO getFactory() {
		return new LibrosDAOImplementacion();
	}
}
