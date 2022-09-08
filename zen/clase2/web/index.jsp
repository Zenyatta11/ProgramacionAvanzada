<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    %>
<!DOCTYPE html>
<html>
<head>

<title>Mi primer JSP</title>
</head>

<%!
	//DEFINICION
	private String nombre = "Martin";

	public String getNombre(){
		return this.nombre;
	}
	
	public int sumar(int a, int b){
		return a + b;
	}

%>

<body>

<!-- Expresion -->
<%-- Comentario en JSP --%>
<h4> <%= "Hola Mundo ".concat(". La fecha es: ").concat(String.valueOf(new Date()))%></h4>

<div sytle="border: solid;">
	<ul>
		<%
			//SCRIPTLETS
			for(int i = 0; i < 5; i++) {
				out.println("<li>" + "Item numero " + (i+1) + "</li>");
			}
		%>
	</ul>
</div>

<br>

<div>
	Nombre ingresado: (this) <%= this.nombre %>
	<br>
	Nombre ingresado: (get) <%= this.getNombre() %>
	<br>
	Resultado de la suma: <%= this.sumar(2, 2) %>
</div>

</body>
</html>