<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Mi segundo JSP</title>
	</head>

	<body>
		<h1>Hola Mundo desde una JSP!!! =)</h1>

		<%
		
		for(int i = 0; i < 6; i = i + 1) {
			out.println("Mostramos el mensaje No. " + i + "<br>");	
		}
		
		%>
	</body>
</html>
