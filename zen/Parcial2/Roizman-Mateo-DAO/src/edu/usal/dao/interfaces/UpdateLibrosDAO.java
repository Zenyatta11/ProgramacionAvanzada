package edu.usal.dao.interfaces;

import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Libro;

public interface UpdateLibrosDAO {
	ErrorLevel updateLibro(Libro data);
	ErrorLevel newLibro(Libro data);
	ErrorLevel deleteLibro(Libro data);
}
