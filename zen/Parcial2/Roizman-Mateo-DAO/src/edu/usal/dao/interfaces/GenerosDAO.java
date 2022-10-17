package edu.usal.dao.interfaces;

import java.util.List;
import edu.usal.dominio.Genero;

public interface GenerosDAO {
	List<Genero> getGeneros();
	Genero getGeneroByID(int id);
}
