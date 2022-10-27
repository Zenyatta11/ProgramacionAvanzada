<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Lectura de datos</title>
    </head>

    <body>
    <input type="text" value=<%= request.getParameter("nombre") %> readonly>
        <br>
        <input type="text" value=<%= request.getParameter("apellido") %> readonly>
        <br>
        <input type="submit" value="Enviar">
    </body>
</html>