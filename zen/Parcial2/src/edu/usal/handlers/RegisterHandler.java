package edu.usal.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.dominio.Usuario;
import edu.usal.dominio.usuarios.Cliente;
import edu.usal.factory.UpdateClienteFactory;

import edu.usal.pages.ErrorPage;

public class RegisterHandler {

	public RegisterHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario currentUser = (Usuario)request.getAttribute("currentUser");

		if(currentUser != null) {
			request.setAttribute("redirect", "/");
			request.getRequestDispatcher("/WEB-INF/resources/redirect.jsp").include(request, response);
			return;
		}
		
		request.setAttribute("content", (request.getParameter("action").equals("registerAdmin") ? "register.jsp" : "register.jsp"));
	}

	public RegisterHandler(HttpServletRequest request, HttpServletResponse response, boolean processPOST) throws ServletException, IOException {
		Usuario currentUser = (Usuario)request.getAttribute("currentUser");
		
		if(currentUser != null) {
			request.setAttribute("redirect", "/");
			request.getRequestDispatcher("/WEB-INF/resources/redirect.jsp").include(request, response);
			return;
		}
		
		String nombre = (String)request.getParameter("p_nombre");
		String apellido = (String)request.getParameter("p_apellido");
		int dni = (request.getParameter("p_dni") == null ? -1 : Integer.valueOf(request.getParameter("p_dni")));
		int telefono = (request.getParameter("p_telefono") == null ? -1 : Integer.valueOf(request.getParameter("p_telefono")));
		String email = (String)request.getParameter("p_email");

		if(nombre == null ||
			apellido == null ||
			dni == -1 ||
			telefono == -1 ||
			email == null) {

			request.setAttribute("content", "login.jsp");
			request.setAttribute("errorText", "Hay datos ingresados que son invalidos.<br>" + 
				(nombre == null ? "El nombre es invalido.<br>" : "") +
				(apellido == null ? "El apellido es invalido.<br>" : "") +
				(dni == -1 ? "El dni es invalido.<br>" : "") +
				(telefono == -1 ? "El telefono es invalido.<br>" : "") +
				(email == null ? "El email es invalido.<br>" : ""));
		} else {
			Cliente cliente = new Cliente(dni, nombre, apellido, telefono, email, false, null, null, null);

			new ErrorPage(request, response, UpdateClienteFactory.getFactory().registerCliente(cliente));
		}
	}
}
