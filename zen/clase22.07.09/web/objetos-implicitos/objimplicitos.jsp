<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo obj implícitos</title>
</head>
<body>

	<%
		Enumeration<String> header = request.getHeaderNames();
		out.println("<ul>");
		while(header.hasMoreElements()) {
			out.println("<li>" + header.nextElement() + "</li>");
		}
		out.println("</ul>");
		out.println("<br>");
		out.println("user-agent " + request.getHeader("user-agent"));
		out.println("<br>");
		out.println("host " + request.getHeader("host"));
		out.println("<br>");
		out.println("connection " + request.getHeader("connection"));
		out.println("<br>");
		out.println("content-type " + request.getHeader("Content-Type"));
	%>	
	
	<p>Context-path: ${pageContext.request.contextPath}</p> 
	<p>User-Agent: ${header["user-agent"]}  </p>
	<p>Server info: ${pageContext.servletContext.serverInfo}</p> 	
	
</body>
</html>