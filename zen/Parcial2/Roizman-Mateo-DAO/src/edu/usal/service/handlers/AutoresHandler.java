package edu.usal.service.handlers;

import java.util.ArrayList;
import java.util.List;

import edu.usal.dominio.Autor;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Nacionalidad;
import edu.usal.service.SQLHandler;

public class AutoresHandler extends SQLHandler {

	public List<Autor> getAutores() {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT a.*, p.nombre AS Pais FROM parcial2_autores a, parcial2_paises p WHERE a.Nacionalidad=p.id ORDER BY nombre;");

		List<Autor> retVal = new ArrayList<Autor>();

		for(ArrayList<String> data : rawData) retVal.add(parseDataToAutor(data));
		
		return retVal;
	}

	public Autor getAutorByID(int id) {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT a.*, p.nombre AS Pais FROM parcial2_autores a, parcial2_paises p WHERE a.id='" + id + "' AND a.Nacionalidad=p.id ORDER BY nombre");

		return (rawData.size() == 0 ? null : parseDataToAutor(rawData.get(0)));
	}
	
	private Autor parseDataToAutor(ArrayList<String> data) {
		return new Autor(Integer.valueOf(data.get(0)),
				data.get(1),
				data.get(2),
				new Nacionalidad(Integer.valueOf(data.get(3)), data.get(4)));
	}

	public ErrorLevel updateAutor(Autor data) {
		return new ErrorLevel(MySQL_Eval("UPDATE parcial2_autores SET " + 
			"id='" + data.getID() + "', " + 
			"Nombre='" + data.getNombre() + "', " + 
			"Apellido='" + data.getApellido() + "', " + 
			"Nacionalidad='" + data.getNacionalidad().getID() + "'" + 
			"WHERE id='" + data.getID() + "');"));
	}

	public ErrorLevel deleteAutor(Autor data) {
		return new ErrorLevel(MySQL_Eval("DELETE FROM parcial2_autores " +
			"WHERE id='" + data.getID() + "');"));
	}

	public ErrorLevel newAutor(Autor data) { 
		boolean success = MySQL_Eval("INSERT INTO parcial2_autores(id, Nombre, Apellido, Nacionalidad) VALUES(" + 
		"'" + data.getID() + "', " + 
		"'" + data.getNombre() + "', " + 
		"'" + data.getApellido() + "', " + 
		"'" + data.getNacionalidad().getID() + "');");
		return new ErrorLevel(success, (success ? "El autor fue agregado con exito!" : "Hubo un error al agregar el autor."));
	}
}