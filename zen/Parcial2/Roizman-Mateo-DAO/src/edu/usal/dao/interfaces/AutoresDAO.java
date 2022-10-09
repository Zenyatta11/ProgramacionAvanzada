package edu.usal.dao.interfaces;

import java.util.List;
import edu.usal.dominio.Autor;

public interface AutoresDAO {
	List<Autor> getAutores();
	Autor getAutorByID(int id);
}
