package edu.usal.dao.implementaciones;

import java.util.List;

import edu.usal.dao.interfaces.LibrosDAO;
import edu.usal.dominio.Libro;
import edu.usal.service.handlers.LibrosHandler;

public class LibrosDAOImplementacion implements LibrosDAO {
	public List<Libro> getLibros() {
		return new LibrosHandler().getLibros();
	}

	public Libro getLibroByID(int id) {
		return new LibrosHandler().getLibroByID(id);
	}

}
