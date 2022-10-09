<%
final String rootDirectory = "https://java.batatas.club/ProgramacionAvanzada/zen/Parcial2"; 
// Esto esta porque el proyecto esta en un subdirectorio del servidor
// y hay miles de paginas web corriendo en el sistema.
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Parcial 2 - Programación Avanzada</title>
		<!-- El ?fin20 es para que no se cachee mal -->
		<link rel="stylesheet" type="text/css" href="<%=rootDirectory%>/resources/index.css?fin20">
	</head>

	<body>
		<div id="wrapper" style="width: 90%">