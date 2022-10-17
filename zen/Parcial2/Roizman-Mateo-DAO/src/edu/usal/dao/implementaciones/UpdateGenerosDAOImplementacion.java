package edu.usal.dao.implementaciones;

import edu.usal.dao.interfaces.UpdateGenerosDAO;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Genero;
import edu.usal.service.handlers.GenerosHandler;

public class UpdateGenerosDAOImplementacion implements UpdateGenerosDAO {
	
	public ErrorLevel updateGenero(Genero data) {
		return new GenerosHandler().updateGenero(data);
	}

	public ErrorLevel newGenero(Genero data) {
		return new GenerosHandler().newGenero(data);

	}

	public ErrorLevel deleteGenero(Genero data) {
		return new GenerosHandler().deleteGenero(data);
	}	
}
