package edu.usal.service.handlers;

import java.util.List;
import java.util.ArrayList;

import edu.usal.service.SQLHandler;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Usuario;
import edu.usal.dominio.usuarios.Cliente;
import edu.usal.dominio.usuarios.Administrador;

public class UsersHandler extends SQLHandler {

	public ErrorLevel validateCliente(int dni, Administrador admin) {
		return new ErrorLevel(MySQL_Eval("UPDATE parcial2_usuarios SET activo=1, FechaHabilitado=NOW(), idAdmin='" + admin.getDNI() + "' WHERE DNI='" + dni + "'"));
	}

	public ErrorLevel updateCliente(Cliente usuario) {
		Cliente cliente = (Cliente)usuario;

		return new ErrorLevel(MySQL_Eval("UPDATE parcial2_usuarios SET " + 
			"Nombre='" + cliente.getNombre() + "', " + 
			"Apellido='" + cliente.getApellido() + "', " + 
			"Telefono='" + cliente.getTelefono() + "', " + 
			"Email='" + cliente.getEmail() + "', " + 
			"Activo='" + cliente.getActivo() + "'" + 
			"WHERE DNI='" + cliente.getDNI() + "');"));
	}

	public ErrorLevel registerCliente(Cliente usuario) { 
		if(getUserByDNI(usuario.getDNI()) != null) return new ErrorLevel(false, "Ya existe una cuenta con ese DNI.");
		
		boolean success = MySQL_Eval("INSERT INTO parcial2_usuarios(DNI, Nombre, Apellido, Telefono, Email) VALUES(" + 
		"'" + usuario.getDNI() + "', " + 
		"'" + usuario.getNombre() + "', " + 
		"'" + usuario.getApellido() + "', " + 
		"'" + usuario.getTelefono() + "', " + 
		"'" + usuario.getEmail() + "');");
		return new ErrorLevel(success, (success ? "Su cuenta fue creada con exito!<br><br>Aguarde a la habilitacion de un administrador para poder iniciar sesion.<br>" : "Hubo un error al crear su cuenta."));
	}

	public List<Cliente> getClientes() {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_usuarios;");
		List<Cliente> retVal = new ArrayList<Cliente>();

		for(ArrayList<String> cliente : rawData) {
			
			retVal.add(new Cliente(
				Integer.valueOf(cliente.get(0)), // DNI
				cliente.get(1), // Nombre
				cliente.get(2), // Apellido
				Integer.valueOf(cliente.get(3)), // Telefono
				cliente.get(4), // E-Mail
				cliente.get(5).equals("1"), // Activo
				parseSQLDate(cliente.get(6)), // Fecha registro
				parseSQLDate(cliente.get(7)), // Fecha Habilitacion
				(cliente.get(8) == null ? null : (Administrador)getUserByDNI(Integer.valueOf(cliente.get(8)))))); // Admin habilitador
		}

		return retVal;
	}

	public List<Administrador> getAdministradores() {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_administradores;");
		List<Administrador> retVal = new ArrayList<Administrador>();

		for(ArrayList<String> administrador : rawData) {
			
			retVal.add(new Administrador(
				Integer.valueOf(administrador.get(0)), // DNI
				administrador.get(1), // Nombre
				administrador.get(2), // Apellido
				Integer.valueOf(administrador.get(3)), // Telefono
				Integer.valueOf(administrador.get(4)))); // Legajo
		}

		return retVal;
	}

	public Usuario getUserByDNI(int dni) {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_usuarios WHERE DNI='" + dni + "'");

		if(rawData.size() == 0) {
			rawData = MySQL_Query("SELECT * FROM parcial2_administradores WHERE DNI='" + dni + "'");
			
			if(rawData.size() == 0) {
				return null;
			} else {
				// DNI, String nombre, String apellido, int telefono, String email, int legajo
				List<String> administrador = rawData.get(0);
				return new Administrador(
					Integer.valueOf(administrador.get(0)), // DNI
					administrador.get(1), // Nombre
					administrador.get(2), // Apellido
					Integer.valueOf(administrador.get(3)), // Telefono
					Integer.valueOf(administrador.get(4))); // Legajo
			}
		} else {
			List<String> cliente = rawData.get(0);
			return new Cliente(
				Integer.valueOf(cliente.get(0)), // DNI
				cliente.get(1), // Nombre
				cliente.get(2), // Apellido
				Integer.valueOf(cliente.get(3)), // Telefono
				cliente.get(4), // E-Mail
				cliente.get(5).equals("1"), // Activo
				parseSQLDate(cliente.get(6)), // Fecha registro
				parseSQLDate(cliente.get(7)), // Fecha Habilitacion
				(cliente.get(8) == null ? null : (Administrador)getUserByDNI(Integer.valueOf(cliente.get(8))))); // Admin habilitador
		}
	}

	public List<Cliente> getClientesConLease() {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT u.* FROM parcial2_usuarios u, parcial2_reservas r WHERE r.Usuario=u.DNI");
		List<Cliente> retVal = new ArrayList<Cliente>();

		for(ArrayList<String> cliente : rawData) {
			
			retVal.add(new Cliente(
				Integer.valueOf(cliente.get(0)), // DNI
				cliente.get(1), // Nombre
				cliente.get(2), // Apellido
				Integer.valueOf(cliente.get(3)), // Telefono
				cliente.get(4), // E-Mail
				cliente.get(5).equals("1"), // Activo
				parseSQLDate(cliente.get(6)), // Fecha registro
				parseSQLDate(cliente.get(7)), // Fecha Habilitacion
				(Administrador)getUserByDNI(Integer.valueOf(cliente.get(8))))); // Admin habilitador
		}

		return retVal;
	}

	public List<Cliente> getClientesSinHabilitar() {
		List<ArrayList<String>> rawData = MySQL_Query("SELECT * FROM parcial2_usuarios WHERE Activo='0';");
		List<Cliente> retVal = new ArrayList<Cliente>();

		for(ArrayList<String> cliente : rawData) {
			
			retVal.add(new Cliente(
				Integer.valueOf(cliente.get(0)), // DNI
				cliente.get(1), // Nombre
				cliente.get(2), // Apellido
				Integer.valueOf(cliente.get(3)), // Telefono
				cliente.get(4), // E-Mail
				false, // Activo
				parseSQLDate(cliente.get(6)), // Fecha registro
				null, // Fecha Habilitacion
				null)); // Admin habilitador
		}

		return retVal;
	}
}