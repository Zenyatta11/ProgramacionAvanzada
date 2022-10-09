package edu.usal.dao.interfaces;

import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.usuarios.Administrador;
import edu.usal.dominio.usuarios.Cliente;

public interface UpdateClienteDAO {
	ErrorLevel validateCliente(int dni, Administrador admin);
	ErrorLevel updateCliente(Cliente usuario);
	ErrorLevel registerCliente(Cliente usuario);
}
