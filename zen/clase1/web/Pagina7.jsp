<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Mi tercer JSP</title>
	</head>

		<%!public int suma(int a, int b) {
			return a + b;
		}%>

	<body>
		<h1>Hola mundo desde un JSP!!! =)</h1>
		
		<h3>La suma de 2 + 5 es <%=suma(2, 5)%></h3>
	</body>
</html>
