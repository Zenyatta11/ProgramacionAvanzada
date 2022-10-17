package edu.usal.dao.implementaciones;

import edu.usal.dao.interfaces.UpdateClienteDAO;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.usuarios.Cliente;
import edu.usal.dominio.usuarios.Administrador;
import edu.usal.service.handlers.UsersHandler;

public class UpdateClienteDAOImplementacion implements UpdateClienteDAO {
	public ErrorLevel validateCliente(int dni, Administrador admin) {
		return new UsersHandler().validateCliente(dni, admin);
	}

	public ErrorLevel updateCliente(Cliente usuario) {
		return new UsersHandler().updateCliente(usuario);
	}

	public ErrorLevel registerCliente(Cliente usuario) { 
		return new UsersHandler().registerCliente(usuario);
	}
}
