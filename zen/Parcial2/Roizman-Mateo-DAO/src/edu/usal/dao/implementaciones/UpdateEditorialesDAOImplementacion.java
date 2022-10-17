package edu.usal.dao.implementaciones;

import edu.usal.dao.interfaces.UpdateEditorialesDAO;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Editorial;
import edu.usal.service.handlers.EditorialesHandler;

public class UpdateEditorialesDAOImplementacion implements UpdateEditorialesDAO {
	
	public ErrorLevel updateEditorial(Editorial data) {
		return new EditorialesHandler().updateEditorial(data);
	}

	public ErrorLevel newEditorial(Editorial data) {
		return new EditorialesHandler().newEditorial(data);

	}

	public ErrorLevel deleteEditorial(Editorial data) {
		return new EditorialesHandler().deleteEditorial(data);
	}	
}
