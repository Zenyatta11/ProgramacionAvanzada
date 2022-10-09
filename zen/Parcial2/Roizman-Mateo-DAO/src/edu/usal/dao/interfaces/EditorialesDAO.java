package edu.usal.dao.interfaces;

import java.util.List;
import edu.usal.dominio.Editorial;

public interface EditorialesDAO {
	List<Editorial> getEditoriales();
	Editorial getEditorialByID(int id);
}
