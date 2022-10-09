package edu.usal.dominio;

public class Autor {
	private final int id;
	private final String nombre;
	private final String apellido;
	private final Nacionalidad nacionalidad;

	public Autor(int id, String nombre, String apellido, Nacionalidad nacionalidad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
	}

	public int getID() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public String getNombreCompleto() {
		return this.getNombre() + ' ' + this.getApellido();
	}

	public Nacionalidad getNacionalidad() {
		return this.nacionalidad;
	}

	public String getPais() {
		return this.getNacionalidad().getNombre();
	}

	
	//No hay setters ya que este objeto sera de solo lectura.
	//Utilizaremos el UpdateDAO para hacer modificaciones directamente sobre la base de datos.
}
