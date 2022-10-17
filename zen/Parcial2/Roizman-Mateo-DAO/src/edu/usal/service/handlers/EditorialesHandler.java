package edu.usal.service.handlers;

import java.util.ArrayList;
import java.util.List;

import edu.usal.dominio.Editorial;
import edu.usal.dominio.ErrorLevel;
import edu.usal.service.SQLHandler;

public class EditorialesHandler extends SQLHandler {

	public List<Editorial> getEditoriales() {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_editoriales ORDER BY nombre;");

		List<Editorial> retVal = new ArrayList<Editorial>();

		for(ArrayList<String> data : rawData) retVal.add(parseDataToEditorial(data));
		
		return retVal;
	}

	public Editorial getEditorialByID(int id) {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_editoriales WHERE id='" + id + "' ORDER BY nombre;");

		return (rawData.size() == 0 ? null : parseDataToEditorial(rawData.get(0)));
	}

	private Editorial parseDataToEditorial(ArrayList<String> data) {
		return new Editorial(Integer.valueOf(data.get(0)),
				data.get(1),
				data.get(2),
				data.get(3),
				data.get(4),
				Integer.valueOf(data.get(5)));
	}

	public ErrorLevel updateEditorial(Editorial data) {
		return new ErrorLevel(MySQL_Eval("UPDATE parcial2_editoriales SET " + 
			"id='" + data.getID() + "', " + 
			"Nombre='" + data.getNombre() + "', " + 
			"Direccion='" + data.getDireccion() + "', " + 
			"PaginaWeb='" + data.getPaginaWeb() + "', " + 
			"Email='" + data.getEmail() + "', " + 
			"Telefono='" + data.getTelefono() + "'" +
			"WHERE ISBN='" + data.getID() + "');"));
	}

	public ErrorLevel deleteEditorial(Editorial data) {
		return new ErrorLevel(MySQL_Eval("DELETE FROM parcial2_editoriales " +
			"WHERE id='" + data.getID() + "');"));
	}

	public ErrorLevel newEditorial(Editorial data) { 
		boolean success = MySQL_Eval("INSERT INTO parcial2_editoriales(id, Nombre, Direccion, PaginaWeb, Email, Telefono) VALUES(" + 
		"'" + data.getID() + "', " + 
		"'" + data.getNombre() + "', " + 
		"'" + data.getDireccion() + "', " + 
		"'" + data.getPaginaWeb() + "', " + 
		"'" + data.getEmail() + "', " + 
		"'" + data.getTelefono() + "');");
		return new ErrorLevel(success, (success ? "La editorial fue agregado con exito!" : "Hubo un error al agregar la editorial."));
	}
}
