package edu.usal.factory;

import edu.usal.dao.implementaciones.UpdateClienteDAOImplementacion;
import edu.usal.dao.interfaces.UpdateClienteDAO;

public class UpdateClienteFactory {

	public static UpdateClienteDAO getFactory() {
		return new UpdateClienteDAOImplementacion();
	}
}
