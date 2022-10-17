package edu.usal.dao.implementaciones;

import java.util.List;

import edu.usal.dao.interfaces.ClienteDAO;
import edu.usal.dominio.Usuario;
import edu.usal.dominio.usuarios.Cliente;
import edu.usal.dominio.usuarios.Administrador;
import edu.usal.service.handlers.UsersHandler;

public class ClienteDAOImplementacion implements ClienteDAO {
	public List<Cliente> getClientes() {
		return new UsersHandler().getClientes();
	}

	public List<Administrador> getAdministradores() {
		return new UsersHandler().getAdministradores();
	}

	public Usuario getUserByDNI(int dni) {
		return new UsersHandler().getUserByDNI(dni);
	}

	public List<Cliente> getClientesConLease() {
		return new UsersHandler().getClientesConLease();
	}

	public List<Cliente> getClientesSinHabilitar() {
		return new UsersHandler().getClientesSinHabilitar();
	}
}
