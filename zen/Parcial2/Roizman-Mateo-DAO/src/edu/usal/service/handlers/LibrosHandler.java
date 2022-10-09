package edu.usal.service.handlers;

import java.util.ArrayList;
import java.util.List;

import edu.usal.dominio.Autor;
import edu.usal.dominio.Editorial;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Genero;
import edu.usal.dominio.Libro;
import edu.usal.dominio.Nacionalidad;
import edu.usal.service.SQLHandler;

public class LibrosHandler extends SQLHandler {

	//List<Libro> getLibros();
	//Libro getLibroByID(int id);

	public List<Libro> getLibros() {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT " +
				"l.ISBN, l.Titulo, l.Paginas, l.Edicion, " +
				"a.id AS idAutor, a.Nombre, a.Apellido, " +
				"p.id AS idPais, p.Nombre AS Pais, " +
				"g.id AS idGenero, g.Nombre AS Genero, " + 
				"e.id AS idEditorial, e.Nombre AS Editorial, e.Direccion, e.PaginaWeb, e.Email, e.Telefono, l.Stock " +
			"FROM parcial2_libros l, parcial2_autores a, parcial2_paises p, parcial2_editoriales e, parcial2_generos g " +
			"WHERE l.Autor=a.id AND l.Genero=g.id AND a.Nacionalidad=p.id AND l.Editorial=e.id " +
			"ORDER BY l.Titulo;");

		List<Libro> retVal = new ArrayList<Libro>();

		for(ArrayList<String> data : rawData) retVal.add(parseDataToLibro(data));
		
		return retVal;
	}

	public Libro getLibroByID(int isbn) {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT " +
				"l.ISBN, l.Titulo, l.Paginas, l.Edicion, " +
				"a.id AS idAutor, a.Nombre, a.Apellido, " +
				"p.id AS idPais, p.Nombre AS Pais, " +
				"g.id AS idGenero, g.Nombre AS Genero, " + 
				"e.id AS idEditorial, e.Nombre AS Editorial, e.Direccion, e.PaginaWeb, e.Email, e.Telefono, l.Stock " +
			"FROM parcial2_libros l, parcial2_autores a, parcial2_paises p, parcial2_editoriales e, parcial2_generos g " +
			"WHERE l.Autor=a.id AND l.Genero=g.id AND a.Nacionalidad=p.id AND l.Editorial=e.id AND l.ISBN='" + isbn + "'" +
			"ORDER BY l.Titulo;");

		return (rawData.size() == 0 ? null : parseDataToLibro(rawData.get(0)));
	}

	private Libro parseDataToLibro(ArrayList<String> data) {
		return new Libro(
			Integer.valueOf(data.get(0)), // ISBN
			new Autor(Integer.valueOf(data.get(4)), // id Autor
				data.get(5), // Nombre Autor
				data.get(6), // Apellido Autor
				new Nacionalidad(Integer.valueOf(data.get(7)), // id Pais
					data.get(8))), // Pais
			data.get(1), // Titulo
			Integer.valueOf(data.get(2)), // Paginas
			new Genero(Integer.valueOf(data.get(9)), // id Genero
				data.get(10)), // Genero
			data.get(3), // Edicion
			new Editorial(Integer.valueOf(data.get(11)), // id Editorial
				data.get(12), // Nombre Editorial
				data.get(13), // Direccion Editorial
				data.get(14), // Pagina Web
				data.get(15), // Email Editorial
				Integer.valueOf(data.get(16))), // Telefono Editorial
			Integer.valueOf(data.get(17))); // Stock del libro
	}

	public ErrorLevel updateLibro(Libro data) {
		return new ErrorLevel(MySQL_Eval("UPDATE parcial2_libros SET " + 
			"ISBN='" + data.getID() + "', " + 
			"Autor='" + data.getAutor().getID() + "', " + 
			"Titulo='" + data.getNombre() + "', " + 
			"Paginas='" + data.getPaginas() + "', " + 
			"Genero='" + data.getGenero().getID() + "', " + 
			"Edicion='" + data.getEdicion() + "', " + 
			"Editorial='" + data.getEditorial().getID() + "', " + 
			"Stock='" + data.getStockTotal() + "'" + 
			"WHERE ISBN='" + data.getID() + "');"));
	}

	public ErrorLevel deleteLibro(Libro data) {
		return new ErrorLevel(MySQL_Eval("DELETE FROM parcial2_libros " +
			"WHERE ISBN='" + data.getID() + "');"));
	}

	public ErrorLevel newLibro(Libro data) { 
		boolean success = MySQL_Eval("INSERT INTO parcial2_libros(ISBN, Autor, Titulo, Paginas, Genero, Edicion, Editorial, Stock) VALUES(" + 
		"'" + data.getID() + "', " + 
		"'" + data.getAutor().getID() + "', " + 
		"'" + data.getNombre() + "', " + 
		"'" + data.getPaginas() + "', " + 
		"'" + data.getGenero().getID() + "', " + 
		"'" + data.getEdicion() + "', " + 
		"'" + data.getEditorial().getID() + "', " + 
		"'" + data.getStockTotal() + "');");
		return new ErrorLevel(success, (success ? "El libro fue agregado con exito!" : "Hubo un error al agregar el libro."));
	}
}
