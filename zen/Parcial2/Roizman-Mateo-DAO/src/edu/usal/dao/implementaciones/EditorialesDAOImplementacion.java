package edu.usal.dao.implementaciones;

import java.util.List;

import edu.usal.dao.interfaces.EditorialesDAO;
import edu.usal.dominio.Editorial;
import edu.usal.service.handlers.EditorialesHandler;

public class EditorialesDAOImplementacion implements EditorialesDAO {
	public List<Editorial> getEditoriales() {
		return new EditorialesHandler().getEditoriales();
	}

	public Editorial getEditorialByID(int id) {
		return new EditorialesHandler().getEditorialByID(id);
	}

}
