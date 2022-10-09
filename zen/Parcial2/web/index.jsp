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
			<%@include file="<%=rootDirectory + "/resources/topSection.jsp"%>"%>
			<%@include file="<%=rootDirectory + "/resources/contentSection.jsp"%>"%>
			<%@include file="<%=rootDirectory + "/resources/footer.jsp"%>"%>
		</div>
		<br>
		<a class="weatherwidget-io" 
			href="https://forecast7.com/es/n34d48n58d91/pilar/" 
			data-label_1="PILAR" 
			data-label_2="EL TIEMPO" 
			data-theme="original" 
			style="display: block; position: relative; height: 98px; padding: 0px; overflow: hidden; text-align: left; text-indent: -299rem;">
				PILAR EL TIEMPO
			<iframe id="weatherwidget-io-0" 
				class="weatherwidget-io-frame" 
				title="Weather Widget" 
				scrolling="no" 
				src="https://weatherwidget.io/w/" 
				style="display: block; position: absolute; top: 0px; height: 98px;" 
				width="100%" 
				frameborder="0"></iframe>
		</a>
	</body>
</html>

