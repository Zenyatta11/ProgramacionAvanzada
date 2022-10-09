package edu.usal.factory;

import edu.usal.dao.implementaciones.NacionalidadesDAOImplementacion;
import edu.usal.dao.interfaces.NacionalidadesDAO;

public class NacionalidadesFactory {

	public static NacionalidadesDAO getFactory() {
		return new NacionalidadesDAOImplementacion();
	}
}
