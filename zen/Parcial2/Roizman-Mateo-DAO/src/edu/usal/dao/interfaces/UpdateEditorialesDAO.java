package edu.usal.dao.interfaces;

import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Editorial;

public interface UpdateEditorialesDAO {
	ErrorLevel updateEditorial(Editorial data);
	ErrorLevel newEditorial(Editorial data);
	ErrorLevel deleteEditorial(Editorial data);
}
