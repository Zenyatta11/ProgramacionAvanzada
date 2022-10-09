package edu.usal.dominio;

public class Genero {
	private int id;
	private String nombre;

	public Genero(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getID() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	//No hay setters ya que este objeto sera de solo lectura.
	//Utilizaremos el UpdateDAO para hacer modificaciones directamente sobre la base de datos.
}
