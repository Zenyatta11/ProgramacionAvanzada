package edu.usal.dominio;

public class Editorial {
	private final int id;
	private final String nombre;
	private final String direccion;
	private final String paginaWeb;
	private final String email;
	private final int telefono;

	public Editorial(int id, String nombre, String direccion, String paginaWeb, String email, int telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.paginaWeb = paginaWeb;
		this.email = email;
		this.telefono = telefono;
	}

	public int getID() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPaginaWeb() {
		return this.paginaWeb;
	}

	public int getTelefono() {
		return this.telefono;
	}

	//No hay setters ya que este objeto sera de solo lectura.
	//Utilizaremos el UpdateDAO para hacer modificaciones directamente sobre la base de datos.
}
