package edu.usal.dao.interfaces;

import java.util.List;
import edu.usal.dominio.Libro;

public interface LibrosDAO {
	List<Libro> getLibros();
	Libro getLibroByID(int id);
}
