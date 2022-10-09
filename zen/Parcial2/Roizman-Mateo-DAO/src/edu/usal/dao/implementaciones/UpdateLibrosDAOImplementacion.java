package edu.usal.dao.implementaciones;

import edu.usal.dao.interfaces.UpdateLibrosDAO;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Libro;
import edu.usal.service.handlers.LibrosHandler;

public class UpdateLibrosDAOImplementacion implements UpdateLibrosDAO {
	
	public ErrorLevel updateLibro(Libro data) {
		return new LibrosHandler().updateLibro(data);
	}

	public ErrorLevel newLibro(Libro data) {
		return new LibrosHandler().newLibro(data);

	}

	public ErrorLevel deleteLibro(Libro data) {
		return new LibrosHandler().deleteLibro(data);
	}	
}
