package edu.usal.service.handlers;

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.StringWriter;
import java.io.PrintWriter;

import edu.usal.service.SQLHandler;
import edu.usal.service.LogHandler;
import edu.usal.dominio.ErrorLevel;
import edu.usal.dominio.Usuario;
import edu.usal.dominio.usuarios.Cliente;
import edu.usal.dominio.usuarios.Administrador;

public class SessionHandler extends SQLHandler {
	public Usuario checkSession(int sessionID) {
		return getUserBySessionID(sessionID);
	}

	public ErrorLevel login(String username, String passwd) {
		List<ArrayList<String>> result = super.MySQL_Query("SELECT DNI FROM parcial2_usuarios WHERE Nombre='" + username + "' AND DNI='" + passwd + "' AND Activo=1 LIMIT 1;");
		if(result.size() == 0) return new ErrorLevel(false, "El usuario y contraseña estan mal o su cuenta aun no fue habilitada.");
		
		Connection SQLConnection = super.MySQL_Connect();
		int newSessionID = (int)(System.currentTimeMillis());
		if(newSessionID < 0) newSessionID = -newSessionID;

		String query = "INSERT INTO parcial2_sessions(Session, DNI) VALUES(?, ?);";
		
		try {
			PreparedStatement preparedStatement = SQLConnection.prepareStatement(query);
			preparedStatement.setInt(1, newSessionID);
			preparedStatement.setInt(2, Integer.valueOf(result.get(0).get(0)));
			preparedStatement.executeUpdate();
			preparedStatement.close();
			SQLConnection.close();

			return new ErrorLevel(String.valueOf(newSessionID), "/");
		} catch(SQLException e) {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			
			return new ErrorLevel(false, stringWriter.toString(), "/error?type=500");
		} catch(Exception e) {
			new LogHandler(e);
			return new ErrorLevel(false, "Exception", "/error?type=500");
		}
	}

	public ErrorLevel logout(int sessionID) {
		List<ArrayList<String>> result = super.MySQL_Query("SELECT s.DNI FROM parcial2_sessions s, parcial2_usuarios u WHERE s.Session='" + sessionID + "' AND s.DNI=u.DNI LIMIT 1;");
		if(result.size() == 0) return new ErrorLevel("", "/"); // La sesion no existe, ya fue invalidada, o el usuario no existe

		int dni = Integer.valueOf(result.get(0).get(0));

		Connection SQLConnection = super.MySQL_Connect();
		String query = "DELETE FROM parcial2_sessions WHERE DNI=?";
		
		try {
			PreparedStatement preparedStatement = SQLConnection.prepareStatement(query);
			preparedStatement.setInt(1, dni);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			SQLConnection.close();

			return new ErrorLevel("", "/");
		} catch(SQLException e) {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			
			return new ErrorLevel(false, stringWriter.toString(), "/error?type=500");
		} catch(Exception e) {
			new LogHandler(e);
			System.exit(-1);
		}
		
		return null;
	}

	public ErrorLevel invalidateSession(int sessionID) {
		return logout(sessionID);
	}

	private Usuario getUserBySessionID(int sessionID) {
		List<ArrayList<String>> result = super.MySQL_Query("SELECT u.* FROM parcial2_usuarios u, parcial2_sessions s WHERE s.Session='" + sessionID + "' AND s.DNI=u.DNI;");
		if(result.size() == 0) {
			return getAdminBySessionID(sessionID);
		}
		
		ArrayList<String> userFields = result.get(0);
		
		return new Cliente(
				Integer.valueOf(userFields.get(0)),
				userFields.get(1),
				userFields.get(2) + "[" + userFields.get(6) + "|" + userFields.get(7) + "|" + userFields.get(8) + "]",
				Integer.valueOf(userFields.get(3)),
				userFields.get(4),
				(Integer.valueOf(userFields.get(5)) == 1 ? true : false),
				parseSQLDate(userFields.get(6)),
				(userFields.get(6) == null ? null : parseSQLDate(userFields.get(7))),
				(userFields.get(8) == null ? null : getAdminByDNI(Integer.valueOf(userFields.get(8))))); 
	}

	private Usuario getAdminBySessionID(int sessionID) {
		List<ArrayList<String>> result = super.MySQL_Query("SELECT a.* FROM parcial2_administradores a, parcial2_sessions s WHERE s.Session='" + sessionID + "' AND s.DNI=u.DNI;");
		if(result.size() == 0) {
			invalidateSession(sessionID);
			return null;
		}
		
		ArrayList<String> userFields = result.get(0);
		return new Administrador(
				Integer.valueOf(userFields.get(0)),
				userFields.get(1),
				userFields.get(2),
				Integer.valueOf(userFields.get(3)),
				Integer.valueOf(userFields.get(4)));
	}

	private Administrador getAdminByDNI(int id) {
		List<ArrayList<String>> result = super.MySQL_Query("SELECT * FROM parcial2_administradores WHERE DNI='" + id + "';");
		if(result.size() == 0) {
			return null;
		}
		
		ArrayList<String> userFields = result.get(0);//DNI 	Nombre 	Apellido 	Telefono 	Legajo 	
		return new Administrador(
				Integer.valueOf(userFields.get(0)),
				userFields.get(1),
				userFields.get(2),
				Integer.valueOf(userFields.get(3)),
				Integer.valueOf(userFields.get(4)));
	}
}