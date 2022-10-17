package edu.usal.dao.implementaciones;

import edu.usal.dao.interfaces.UpdateAutoresDAO;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Autor;
import edu.usal.service.handlers.AutoresHandler;

public class UpdateAutoresDAOImplementacion implements UpdateAutoresDAO {
	
	public ErrorLevel updateAutor(Autor data) {
		return new AutoresHandler().updateAutor(data);
	}

	public ErrorLevel newAutor(Autor data) {
		return new AutoresHandler().newAutor(data);

	}

	public ErrorLevel deleteAutor(Autor data) {
		return new AutoresHandler().deleteAutor(data);
	}	
}
