package edu.usal.dao.interfaces;

import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Autor;

public interface UpdateAutoresDAO {
	ErrorLevel updateAutor(Autor data);
	ErrorLevel newAutor(Autor data);
	ErrorLevel deleteAutor(Autor data);
}
