package edu.usal.dao.implementaciones;

import java.util.List;

import edu.usal.dao.interfaces.GenerosDAO;
import edu.usal.dominio.Genero;
import edu.usal.service.handlers.GenerosHandler;

public class GenerosDAOImplementacion implements GenerosDAO {
	public List<Genero> getGeneros() {
		return new GenerosHandler().getGeneros();
	}

	public Genero getGeneroByID(int id) {
		return new GenerosHandler().getGeneroByID(id);
	}

}
