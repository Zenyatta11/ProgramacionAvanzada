package edu.usal.dominio;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	private final int ISBN;
	private final Autor autor;
	private final String nombre;
	private final int paginas;
	private final Genero genero;
	private final String edicion;
	private final Editorial editorial;
	private final int stock;

	public Libro(int ISBN, Autor autor, String nombre, int paginas, Genero genero, String edicion, Editorial editorial, int stock) {
		this.ISBN = ISBN;
		this.autor = autor;
		this.nombre = nombre;
		this.paginas = paginas;
		this.genero = genero;
		this.edicion = edicion;
		this.editorial = editorial;
		this.stock = stock;
	}

	public int getISBN() {
		return this.ISBN;
	}

	public int getID() {
		return this.getISBN();
	}

	public Autor getAutor() {
		return this.autor;
	}

	public String getEdicion() {
		return this.edicion;
	}

	public Editorial getEditorial() {
		return this.editorial;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getNombreGenero() {
		return this.getGenero().getNombre();
	}

	public String getNombreAutor() {
		return this.getAutor().getNombre();
	}

	public int getPaginas() {
		return this.paginas;
	}

	public String getPaisAutor() {
		return this.getAutor().getPais();
	}

	public int getStockTotal() {
		//El stock disponible depende de las reservas, se manejara en otro lado.
		//Aca enviamos los libros que son de "nuestra propiedad", esten o no disponibles.
		return this.stock;
	}

	public List<String> stringifyData() {
		List<String> retVal = new ArrayList<String>();
		retVal.add(String.valueOf(this.getISBN()));
		retVal.add(this.getNombre());
		retVal.add(this.getGenero().getNombre());
		retVal.add(this.getAutor().getApellido());
		retVal.add(this.getEdicion());
		retVal.add(this.getEditorial().getNombre());
		retVal.add(String.valueOf(this.getPaginas()));
		retVal.add(String.valueOf(this.getStockTotal()));

		return retVal;
	}

	//No hay setters ya que este objeto sera de solo lectura.
	//Utilizaremos el UpdateDAO para hacer modificaciones directamente sobre la base de datos.
}
