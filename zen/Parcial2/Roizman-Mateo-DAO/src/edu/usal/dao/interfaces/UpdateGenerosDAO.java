package edu.usal.dao.interfaces;

import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Genero;

public interface UpdateGenerosDAO {
	ErrorLevel updateGenero(Genero data);
	ErrorLevel newGenero(Genero data);
	ErrorLevel deleteGenero(Genero data);
}
