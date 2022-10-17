package edu.usal.dominio.usuarios;

import edu.usal.dominio.Usuario;

public class Administrador extends Usuario {

	private final int legajo;

	public Administrador(int DNI, String nombre, String apellido, int telefono, int legajo) {
		super(DNI, nombre, apellido, telefono, null, true); 
		// quedo un remanente, me olvide que el admin no tiene email
		// ya es tarde para arreglar eso, el null tendra que ser.

		this.legajo = legajo;
	}

	public int getLegajo() {
		return this.legajo;
	}
}
