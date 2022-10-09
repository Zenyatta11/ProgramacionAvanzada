package edu.usal.dominio.usuarios;

import edu.usal.dominio.Usuario;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Cliente extends Usuario {
	
	private final boolean activo;
	private final Date fechaRegistro;
	private final Date fechaHabilitado;
	private final Administrador habilitador;

	public Cliente(int DNI, String nombre, String apellido, int telefono, String email, boolean activo, Date fechaRegistro, Date fechaHabilitado, Administrador habilitador) {
		super(DNI, nombre, apellido, telefono, email, false);
		this.activo = activo;
		this.fechaRegistro = fechaRegistro;
		this.fechaHabilitado = fechaHabilitado;
		this.habilitador = habilitador;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public Date getFechaHabilitado() {
		if(!this.getActivo()) return null;
		return this.fechaHabilitado;
	}

	public Administrador getHabilitador() {
		if(!this.getActivo()) return null;
		return this.habilitador;
	}

	public List<String> stringifyData() {
		List<String> retVal = new ArrayList<String>();

		retVal.add(String.valueOf(this.getDNI()));
		retVal.add(this.getNombre());
		retVal.add(this.getApellido());
		retVal.add(String.valueOf(this.getTelefono()));
		retVal.add(this.getEmail());
		retVal.add((this.getActivo() ? "Activo" : "Inactivo"));
		retVal.add(this.getFechaRegistro().toString());

		return retVal;
	}
}
