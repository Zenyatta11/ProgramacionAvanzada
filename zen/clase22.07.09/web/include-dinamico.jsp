<html>
<head>
<title>Include dinamico</title>
</head>

<%
	String color = request.getParameter("colorDiv");
	String nombre = request.getParameter("nombre");
%>

<body bgcolor='<%= color %>'>

<h1>Hola <%= nombre %></h1>

<div >
	<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quos error, velit vitae eligendi laudantium obcaecati, porro commodi esse consequatur repellat itaque blanditiis! Omnis minima optio odit, dolor eius non molestiae!</p>
</div>

</body>
</html>