package edu.usal.dao.implementaciones;

import java.util.List;

import edu.usal.dao.interfaces.NacionalidadesDAO;
import edu.usal.dominio.Nacionalidad;
import edu.usal.service.handlers.NacionalidadHandler;

public class NacionalidadesDAOImplementacion implements NacionalidadesDAO {
	public List<Nacionalidad> getNacionalidades() {
		return new NacionalidadHandler().getNacionalidades();
	}

	public Nacionalidad getNacionalidadByID(int id) {
		return new NacionalidadHandler().getNacionalidadByID(id);
	}

}
