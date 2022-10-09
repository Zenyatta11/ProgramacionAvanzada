package edu.usal.service.handlers;

import java.util.ArrayList;
import java.util.List;

import edu.usal.dominio.Nacionalidad;
import edu.usal.service.SQLHandler;

public class NacionalidadHandler extends SQLHandler {

	public List<Nacionalidad> getNacionalidades() {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_paises ORDER BY nombre;");

		List<Nacionalidad> retVal = new ArrayList<Nacionalidad>();

		for(ArrayList<String> data : rawData) retVal.add(parseDataToNacionalidad(data));
		
		return retVal;
	}

	public Nacionalidad getNacionalidadByID(int id) {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_paises WHERE id='" + id + "' ORDER BY nombre;");

		return (rawData.size() == 0 ? null : parseDataToNacionalidad(rawData.get(0)));
	}

	private Nacionalidad parseDataToNacionalidad(ArrayList<String> data) {
		return new Nacionalidad(Integer.valueOf(data.get(0)),
				data.get(1));
	}
}
