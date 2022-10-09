package edu.usal.dao.interfaces;

import java.util.List;

import edu.usal.dominio.Usuario;
import edu.usal.dominio.usuarios.Cliente;
import edu.usal.dominio.usuarios.Administrador;

public interface ClienteDAO {
	List<Cliente> getClientes();
	List<Administrador> getAdministradores();
	Usuario getUserByDNI(int dni);
	List<Cliente> getClientesConLease();
	List<Cliente> getClientesSinHabilitar();
}
