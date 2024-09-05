<%-- 
    Document   : nueva-solicitud
    Created on : Sep 4, 2024, 4:31:28 PM
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva solicitud</title>
    </head>
    <body>
        <h1>Nueva solicitud</h1>
        <form method="POST" action="/jsp-app/mvc/solicitudes/solicitudes-servlet">
            <label for="numSolicitud">Numero de solicitud:</label>
            <input id="codigo" name="codigo"/>
            <br>
            <label for="fecha">Fecha:</label>
            <input type="date" id="fecha" name="fecha"/>
            <br>
            <label for="tipo">Tipo:</label>
            <select id="tipo" name="tipo">
                <option value="NACIONAL">NACIONAL</option>
                <option value="REGIONAL">REGIONAL</option>
                <option value="INTERNACIONAL">INTERNACIONAL</option>
            </select>
            <br>
            <label for="nombre">Nombre de la persona:</label>
            <input id="nombre" name="nombrePersona" maxlength="100"/>
            <br>
            <label for="salario">Salario:</label>
            <input id="salario" name="salario" type="number" min="1" />
            <br>
            <label for="salario">Direccion:</label>
            <input id="direccion" name="direccion" maxlength="150"/>
            <br>
            <button>Crear solicitud</button>
        </form>
    </body>
</html>
