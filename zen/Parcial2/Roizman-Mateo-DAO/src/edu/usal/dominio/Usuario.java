package edu.usal.dominio;

public class Usuario extends Persona {
	private final int DNI;
	private final String nombre;
	private final String apellido;
	private final int telefono;
	private final String email;
	private final boolean isAdmin;

	public Usuario(int DNI, String nombre, String apellido, int telefono, String email, boolean isAdmin) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.isAdmin = isAdmin;
	}

	public int getDNI() {
		return this.DNI;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public String getNombreCompleto() {
		return this.getNombre() + ", " + this.getApellido();
	}

	public int getTelefono() {
		return this.telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}

	public boolean isUser() {
		return !this.isAdmin;
	}
}
