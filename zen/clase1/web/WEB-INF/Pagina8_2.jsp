<!DOCTYPE html>
<%@page import="clase1.Calculos"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mi tercer JSP</title>
	</head>

	<body>
		<h1>Hola mundo desde un JSP!!! =)</h1>
		
		<h3>La suma de 2 + 5 es <%= Calculos.suma(2, 5)%></h3>
	</body>
</html>
