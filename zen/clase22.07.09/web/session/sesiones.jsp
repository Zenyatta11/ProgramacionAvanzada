<!DOCTYPE html>
<%@page import="java.util.Date"%>
<html>
<head>
<meta charset="UTF-8">
<title>Demo sesión</title>
</head>
<%
	Date creacionSesion = new Date(session.getCreationTime());
	Date ultimoAcceso = new Date(session.getLastAccessedTime());
	
	Integer contador = new Integer(0);
	
	if(session.isNew()){
		//sesion nueva
		session.setAttribute("contador", contador);
		//session.setAttribute("nombre", "Mati");
	} else {
		if(session.getAttribute("contador")!=null)
		{
			contador = (Integer) session.getAttribute("contador") + 1;
		}
		session.setAttribute("contador", contador);
	}
	
	//Ciclo de vida de la sesion en segundos.
	session.setMaxInactiveInterval(3);
%>
<body>

<table border="1">
	<tr>
		<th>Tipo de informacion</th>
		<th>Valor</th>
	</tr>
	<tr>
		<td>Creacion de sesion</td>
		<td><%= creacionSesion %></td>
	</tr>
	<tr>
		<td>Fecha y Hs ultimo acceso</td>
		<td><%= ultimoAcceso %></td>
	</tr>
	<tr>
		<td>Contador</td>
		<td><%= contador %></td>
	</tr>
	<tr>
		<td>Usuario</td>
		<td><%= request.getParameter("usuario") %></td>
	</tr>
	<tr>
		<td>ID de sesion</td>
		<td><%= session.getId() %></td>
	</tr>
</table>

</body>
</html>