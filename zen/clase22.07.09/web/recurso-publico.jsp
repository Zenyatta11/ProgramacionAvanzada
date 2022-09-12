<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    %>
<!DOCTYPE html>
<html>
<head>

<title>Recurso Publico</title>
</head>
<body>

<!--  navbar  
<ul>
	<li>
		<a href="recurso-publico.jsp">Recurso Publico</a>
		
	</li>
	<li>
		<a href="WEB-INF/recurso-privado.jsp">Recurso Privado</a>
	</li>
</ul>
-->
<%-- Include Dinamico --%>
<jsp:include page="navbar.html"></jsp:include> 
<br>

<h1>Recurso Publico</h1>
<br>
<a href="index.jsp">Volver al index</a>

<%-- Include estatico --%>
<%@include file="footer.html" %>
</body>
</html>