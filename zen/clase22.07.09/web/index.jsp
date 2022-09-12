<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    %>
<!DOCTYPE html>
<html>
<head>

<title>Ejemplo de Recursos Publicos y Privados</title>
</head>
<body>

<!--  navbar  -->
<!-- 
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
<jsp:include page="include-dinamico.jsp">
	<jsp:param value="green" name="colorDiv"/>
	<jsp:param value="Gaston" name="nombre"/>
</jsp:include>
<jsp:include page="WEB-INF/recurso-privado.jsp"></jsp:include>
<br>

<%-- Include estatico --%>
<%@include file="footer.html" %>
</body>
</html>