package edu.usal.dao.implementaciones;

import java.util.List;

import edu.usal.dao.interfaces.AutoresDAO;
import edu.usal.dominio.Autor;
import edu.usal.service.handlers.AutoresHandler;

public class AutoresDAOImplementacion implements AutoresDAO {
	public List<Autor> getAutores() {
		return new AutoresHandler().getAutores();
	}

	public Autor getAutorByID(int id) {
		return new AutoresHandler().getAutorByID(id);
	}

}
