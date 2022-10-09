package edu.usal.service.handlers;

import java.util.ArrayList;
import java.util.List;

import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Genero;
import edu.usal.service.SQLHandler;

public class GenerosHandler extends SQLHandler {

	public List<Genero> getGeneros() {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_generos ORDER BY nombre;");

		List<Genero> retVal = new ArrayList<Genero>();

		for(ArrayList<String> data : rawData) retVal.add(parseDataToGenero(data));
		
		return retVal;
	}

	public Genero getGeneroByID(int id) {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_generos WHERE id='" + id + "' ORDER BY nombre;");

		return (rawData.size() == 0 ? null : parseDataToGenero(rawData.get(0)));
	}

	private Genero parseDataToGenero(ArrayList<String> data) {
		return new Genero(Integer.valueOf(data.get(0)),
				data.get(1));
	}

	public ErrorLevel updateGenero(Genero data) {
		return new ErrorLevel(MySQL_Eval("UPDATE parcial2_generos SET " + 
			"id='" + data.getID() + "', " + 
			"Nombre='" + data.getNombre() + "'" + 
			"WHERE id='" + data.getID() + "');"));
	}

	public ErrorLevel deleteGenero(Genero data) {
		return new ErrorLevel(MySQL_Eval("DELETE FROM parcial2_generos " +
			"WHERE id='" + data.getID() + "');"));
	}

	public ErrorLevel newGenero(Genero data) { 
		boolean success = MySQL_Eval("INSERT INTO parcial2_generos(id, Nombre) VALUES(" + 
		"'" + data.getID() + "', " + 
		"'" + data.getNombre() + "');");
		return new ErrorLevel(success, (success ? "El genero fue agregado con exito!" : "Hubo un error al agregar el Genero."));
	}
}
