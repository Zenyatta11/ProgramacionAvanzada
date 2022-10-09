package edu.usal.handlers;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.dominio.Autor;
import edu.usal.dominio.Editorial;
import edu.usal.dominio.Genero;
import edu.usal.dominio.Libro;
import edu.usal.dominio.Nacionalidad;
import edu.usal.dominio.Usuario;
import edu.usal.dominio.usuarios.Cliente;
	
import edu.usal.factory.AutoresFactory;
import edu.usal.factory.ClienteFactory;
import edu.usal.factory.GenerosFactory;
import edu.usal.factory.LibroFactory;
import edu.usal.factory.NacionalidadesFactory;

public class ViewHandler {

	public ViewHandler(HttpServletRequest request, HttpServletResponse response) {
		String item = (String)request.getParameter("item");
		if(item == null) item = "users";

		switch(item) {
			case "users": tableShowUsers(request, response); break;
			case "libros": tableShowBooks(request, response); break;
		}
	}

	public ViewHandler(HttpServletRequest request, HttpServletResponse response, boolean processPOST) {
		this(request, response);
	}

	private void tableShowUsers(HttpServletRequest request, HttpServletResponse response) {
		List<Cliente> clientes = ClienteFactory.getFactory().getClientes();
		List<ArrayList<String>> payload = new ArrayList<ArrayList<String>>();

		String filtroName = (String)request.getParameter("filterName");
		String filtroApellido = (String)request.getParameter("filterApellido");
		String filtroTelefono = (String)request.getParameter("filterTelefono");
		String filtroEmail = (String)request.getParameter("filterEmail");
		String filtroEstado = (String)request.getParameter("filterEstado");

		for(Cliente cliente : clientes) {
			// Java hace cortocircuitos
			if(filtroName != null && !cliente.getNombre().toUpperCase().contains(filtroName.toUpperCase())) continue;
			if(filtroApellido != null && !cliente.getApellido().toUpperCase().contains(filtroApellido.toUpperCase())) continue;
			if(filtroTelefono != null && !String.valueOf(cliente.getTelefono()).contains(filtroTelefono)) continue;
			if(filtroEmail != null && !cliente.getEmail().toUpperCase().contains(filtroEmail.toUpperCase())) continue;
			if(request.getParameter("filterEstado") != null && cliente.getActivo() != String.valueOf(request.getParameter("filterEstado")).equals("a")) continue;

			payload.add((ArrayList<String>)cliente.stringifyData());
		}

		List<String> headers = new ArrayList<String>();

		headers.add("DNI");
		headers.add("Nombre");
		headers.add("Apellido");
		headers.add("Telefono");
		headers.add("E-Mail");
		headers.add("Estado");
		headers.add("Registrado");

		String filtros = "<th colspan=\"" + headers.size() + "\" style=\"background: #000; color:#FFF;\"><form><span style=\"margin: auto;\">Filtrar:</span>" +
			"<input type=\"text\" name=\"filterName\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Nombre\" value=\"" + (filtroName == null ? "" : filtroName) + "\"/>" +
			"<input type=\"text\" name=\"filterApellido\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Apellido\" value=\"" + (filtroApellido == null ? "" : filtroApellido) + "\"/>" +
			"<input type=\"number\" min=\"0\" name=\"filterTelefono\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Telefono\" value=\"" + (filtroTelefono == null ? "" : filtroTelefono) + "\"/>" +
			"<input type=\"text\" name=\"filterEmail\" style=\"color: #fff !important; margin: auto;\" placeholder=\"E-Mail\" value=\"" + (filtroEmail == null ? "" : filtroEmail) + "\"/>" +
			
			"<select name=\"filterEstado\">" + 
				"<option value=\"\" " + (filtroEstado == null ? "selected" : "") + " disabled>Seleccione</option>" + 
				"<option value=\"a\" " + (filtroEstado == null ? "" : (filtroEstado.equals("a") ? "selected" : "")) + ">Activos</option>" + 
				"<option value=\"i\" " + (filtroEstado == null ? "" : (filtroEstado.equals("i") ? "selected" : "")) + ">Inactivos</option>" + 
			"</select>" +
			"<input type=\"hidden\" name=\"action\" value=\"view\"/>" + 
			"<input type=\"hidden\" name=\"item\" value=\"users\"/>" + 
			"<button type=\"submit\">Filtrar!</button>" +
			"</form><a href=\"?action=view&item=users\"><button>Borrar Filtros</button></a></th>";
		
		request.setAttribute("tableData", payload);
		request.setAttribute("tableHeaders", headers);
		request.setAttribute("tableFilters", filtros);
		request.setAttribute("content", "tableView.jsp");
	}

	private void tableShowBooks(HttpServletRequest request, HttpServletResponse response) {
		List<Libro> libros = LibroFactory.getFactory().getLibros();
		List<ArrayList<String>> payload = new ArrayList<ArrayList<String>>();

		String filtroISBN = (String)request.getParameter("filterName");
		String filtroTitulo = (String)request.getParameter("filterApellido");
		String filtroAutor = (String)request.getParameter("filterTelefono");
		String filtroEdicion = (String)request.getParameter("filterEmail");
		String filtroEditorial = (String)request.getParameter("filterEstado");
		String filtroGenero = (String)request.getParameter("filterEstado");
		String filtroDisponibles = (String)request.getParameter("filterEstado");

		for(Libro libro : libros) {
			// Java hace cortocircuitos
			if(filtroISBN != null && !String.valueOf(libro.getISBN()).toUpperCase().contains(filtroISBN.toUpperCase())) continue;
			if(filtroTitulo != null && !libro.getNombre().toUpperCase().contains(filtroTitulo.toUpperCase())) continue;
			if(filtroAutor != null && !libro.getAutor().getNombreCompleto().toUpperCase().contains(filtroAutor.toUpperCase())) continue;
			if(filtroEdicion != null && !libro.getEdicion().toUpperCase().contains(filtroEdicion.toUpperCase())) continue;
			if(filtroEditorial != null && !libro.getEditorial().getNombre().toUpperCase().contains(filtroEditorial.toUpperCase())) continue;
			if(request.getParameter("filtroGenero") != null && String.valueOf(request.getParameter("filtroGenero")).equals(String.valueOf(libro.getGenero().getID()))) continue;
			if(request.getParameter("filtroDisponibles") != null && 
				(libro.getStockTotal() > 0 && String.valueOf(request.getParameter("filtroDisponibles")).equals("n") || libro.getStockTotal() == 0 && String.valueOf(request.getParameter("filtroDisponibles")).equals("d"))) continue;

			payload.add((ArrayList<String>)libro.stringifyData());
		}

		List<String> headers = new ArrayList<String>();

		headers.add("ISBN");
		headers.add("Titulo");
		headers.add("Genero");
		headers.add("Autor");
		headers.add("Edicion");
		headers.add("Editorial");
		headers.add("Paginas");
		headers.add("Total");
		headers.add("Disp.");

		String filtros = "<th colspan=\"" + headers.size() + "\" style=\"background: #000; color:#FFF;\"><form><span style=\"margin: auto;\">Filtrar:</span>" +
			"<input type=\"number\" min=\"0\" name=\"filterISBN\" style=\"color: #fff !important; margin: auto;\" placeholder=\"ISBN\" value=\"" + (filtroISBN == null ? "" : filtroISBN) + "\"/>" +
			"<input type=\"text\" name=\"filterTitulo\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Titulo\" value=\"" + (filtroTitulo == null ? "" : filtroTitulo) + "\"/>" +
			"<input type=\"text\" name=\"filterAutor\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Autor\" value=\"" + (filtroAutor == null ? "" : filtroAutor) + "\"/>" +
			"<input type=\"text\" name=\"Edicion\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Edicion\" value=\"" + (filtroEdicion == null ? "" : filtroEdicion) + "\"/>" +
			"<input type=\"text\" name=\"Editorial\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Editorial\" value=\"" + (filtroEditorial == null ? "" : filtroEditorial) + "\"/>" +
			
			"<select name=\"filterGenero\">" + 
				"<option value=\"\" " + (filtroGenero == null ? "selected" : "") + " disabled>Seleccione</option>" + 
				getGenerosAsOption(filtroGenero) + 
			"</select>" +
			
			"<select name=\"filterDisponibles\">" + 
				"<option value=\"\" " + (filtroDisponibles == null ? "selected" : "") + " disabled>Seleccione</option>" + 
				"<option value=\"d\" " + (filtroDisponibles == null ? "" : (filtroDisponibles.equals("d") ? "selected" : "")) + ">Disponibles</option>" + 
				"<option value=\"n\" " + (filtroDisponibles == null ? "" : (filtroDisponibles.equals("n") ? "selected" : "")) + ">Sin Stock</option>" + 
			"</select>" +
			"<input type=\"hidden\" name=\"action\" value=\"view\"/>" + 
			"<input type=\"hidden\" name=\"item\" value=\"libros\"/>" + 
			"<button type=\"submit\">Filtrar!</button>" +
			"</form><a href=\"?action=view&item=books\"><button>Borrar Filtros</button></a></th>";

		request.setAttribute("tableData", payload);
		request.setAttribute("tableHeaders", headers);
		request.setAttribute("tableFilters", filtros);
		request.setAttribute("content", "tableView.jsp");
	}

	private String getGenerosAsOption(String filtroGenero) {
		List<Genero> generos = GenerosFactory.getFactory().getGeneros();
		String retVal = "";

		for(Genero genero : generos) 
			retVal = retVal + 
				"<option value=\"" + genero.getID() + "\"" +
				(String.valueOf(genero.getID()).equals(filtroGenero) ? "selected" : "") +
				">" + genero.getNombre() + "</option>";
		return retVal;
	}

	private String getNacionalidadAsOption(String filtro) {
		List<Nacionalidad> paises = NacionalidadesFactory.getFactory().getNacionalidades();
		String retVal = "";

		for(Nacionalidad pais : paises) 
			retVal = retVal + 
				"<option value=\"" + pais.getID() + "\"" +
				(String.valueOf(pais.getID()).equals(filtro) ? "selected" : "") +
				">" + pais.getNombre() + "</option>";
		return retVal;
	}

	/*private void tableShowAuthors(HttpServletRequest request, HttpServletResponse response) {
		List<Autor> autores = AutoresFactory.getFactory().getAutores();
		List<ArrayList<String>> payload = new ArrayList<ArrayList<String>>();

		String filtroName = (String)request.getParameter("filterName");
		String filtroApellido = (String)request.getParameter("filterApellido");
		String filtroNacionalidad = (String)request.getParameter("filterNacionalidad");

		for(Autor autor : autores) {
			// Java hace cortocircuitos
			if(filtroName != null && !cliente.getNombre().toUpperCase().contains(filtroName.toUpperCase())) continue;
			if(filtroApellido != null && !cliente.getApellido().toUpperCase().contains(filtroApellido.toUpperCase())) continue;
			if(filtroTelefono != null && !String.valueOf(cliente.getTelefono()).contains(filtroTelefono)) continue;
			if(filtroEmail != null && !cliente.getEmail().toUpperCase().contains(filtroEmail.toUpperCase())) continue;
			if(request.getParameter("filterEstado") != null && cliente.getActivo() != String.valueOf(request.getParameter("filterEstado")).equals("a")) continue;

			payload.add((ArrayList<String>)cliente.stringifyData());
		}

		List<String> headers = new ArrayList<String>();
//id 	Nombre 	Apellido 	Nacionalidad 	
		headers.add("Nombre");
		headers.add("Apellido");
		headers.add("Nacionalidad");

		String filtros = "<th colspan=\"" + headers.size() + "\" style=\"background: #000; color:#FFF;\"><form><span style=\"margin: auto;\">Filtrar:</span>" +
			"<input type=\"text\" name=\"filterName\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Nombre\" value=\"" + (filtroName == null ? "" : filtroName) + "\"/>" +
			"<input type=\"text\" name=\"filterApellido\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Apellido\" value=\"" + (filtroApellido == null ? "" : filtroApellido) + "\"/>" +
			
			"<select name=\"filterNacionalidad\">" + 
				"<option value=\"\" " + (filtroEstado == null ? "selected" : "") + " disabled>Seleccione</option>" + 
				getNacionalidadAsOption(filtroNacionalidad) + 
			"</select>" +
			"<input type=\"hidden\" name=\"action\" value=\"view\"/>" + 
			"<input type=\"hidden\" name=\"item\" value=\"authors\"/>" + 
			"<button type=\"submit\">Filtrar!</button>" +
			"</form><a href=\"?action=view&item=authors\"><button>Borrar Filtros</button></a></th>";
			
		request.setAttribute("tableData", payload);
		request.setAttribute("tableHeaders", headers);
		request.setAttribute("tableFilters", filtros);
		request.setAttribute("content", "tableView.jsp");
	}

	private void tableShowEditorial(HttpServletRequest request, HttpServletResponse response) {
		List<Editorial> editoriales = EditorialFactory.getFactory().getClientes();
		List<ArrayList<String>> payload = new ArrayList<ArrayList<String>>();

		String filtroName = (String)request.getParameter("filterName");
		String filtroApellido = (String)request.getParameter("filterApellido");
		String filtroTelefono = (String)request.getParameter("filterTelefono");
		String filtroEmail = (String)request.getParameter("filterEmail");
		String filtroEstado = (String)request.getParameter("filterEstado");

		for(Editorial editorial : editoriales) {
			// Java hace cortocircuitos
			if(filtroName != null && !cliente.getNombre().toUpperCase().contains(filtroName.toUpperCase())) continue;
			if(filtroApellido != null && !cliente.getApellido().toUpperCase().contains(filtroApellido.toUpperCase())) continue;
			if(filtroTelefono != null && !String.valueOf(cliente.getTelefono()).contains(filtroTelefono)) continue;
			if(filtroEmail != null && !cliente.getEmail().toUpperCase().contains(filtroEmail.toUpperCase())) continue;
			if(request.getParameter("filterEstado") != null && cliente.getActivo() != String.valueOf(request.getParameter("filterEstado")).equals("a")) continue;

			payload.add((ArrayList<String>)cliente.stringifyData());
		}

		List<String> headers = new ArrayList<String>();

		headers.add("DNI");
		headers.add("Nombre");
		headers.add("Apellido");
		headers.add("Telefono");
		headers.add("E-Mail");
		headers.add("Estado");
		headers.add("Registrado");

		String filtros = "<th colspan=\"" + headers.size() + "\" style=\"background: #000; color:#FFF;\"><form><span style=\"margin: auto;\">Filtrar:</span>" +
			"<input type=\"text\" name=\"filterName\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Nombre\" value=\"" + (filtroName == null ? "" : filtroName) + "\"/>" +
			"<input type=\"text\" name=\"filterApellido\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Apellido\" value=\"" + (filtroApellido == null ? "" : filtroApellido) + "\"/>" +
			"<input type=\"text\" name=\"filterTelefono\" style=\"color: #fff !important; margin: auto;\" placeholder=\"Telefono\" value=\"" + (filtroTelefono == null ? "" : filtroTelefono) + "\"/>" +
			"<input type=\"text\" name=\"filterEmail\" style=\"color: #fff !important; margin: auto;\" placeholder=\"E-Mail\" value=\"" + (filtroEmail == null ? "" : filtroEmail) + "\"/>" +
			
			"<select name=\"filterEstado\">" + 
				"<option value=\"\" " + (filtroEstado == null ? "selected" : "") + " disabled>Seleccione</option>" + 
				"<option value=\"a\" " + (filtroEstado == null ? "" : (filtroEstado.equals("a") ? "selected" : "")) + ">Activos</option>" + 
				"<option value=\"i\" " + (filtroEstado == null ? "" : (filtroEstado.equals("i") ? "selected" : "")) + ">Inactivos</option>" + 
			"</select>" +
			"<input type=\"hidden\" name=\"action\" value=\"view\"/>" + 
			"<input type=\"hidden\" name=\"item\" value=\"users\"/>" + 
			"<button type=\"submit\">Filtrar!</button>" +
			"</form><a href=\"?action=view&item=editorial\"><button>Borrar Filtros</button></a></th>";
			
		request.setAttribute("tableData", payload);
		request.setAttribute("tableHeaders", headers);
		request.setAttribute("tableFilters", filtros);
		request.setAttribute("content", "tableView.jsp");
	}*/

	/*
	?action=view&item=books
?action=view&item=authors
?action=view&item=editorial
?action=view&item=users
?action=view&item=usersDisabled
?action=view&item=admins
?action=view&item=leased
?action=view&item=leases
*/
}
