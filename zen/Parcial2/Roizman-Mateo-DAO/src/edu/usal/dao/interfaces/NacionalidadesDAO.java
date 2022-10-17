package edu.usal.dao.interfaces;

import java.util.List;
import edu.usal.dominio.Nacionalidad;

public interface NacionalidadesDAO {
	List<Nacionalidad> getNacionalidades();
	Nacionalidad getNacionalidadByID(int id);
}
