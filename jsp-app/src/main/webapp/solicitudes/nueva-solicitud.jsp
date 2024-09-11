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
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="/includes/header.jsp"/>
        <main>
            <section class="section">
                <div class="container">
                    <h1>Nueva solicitud</h1>
                    <form method="POST" action="${pageContext.servletContext.contextPath}/mvc/solicitudes/solicitudes-servlet">
                        <div class="form-group">
                            <label for="numSolicitud">Numero de solicitud:</label>
                            <input id="codigo" name="codigo" class="form-control" placeholder="Numero de solicitud"/>
                        </div>
                        <div class="form-group">
                            <label for="fecha">Fecha:</label>
                            <input type="date" id="fecha" name="fecha" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="tipo">Tipo:</label>
                            <select id="tipo" name="tipo" class="form-control">
                                <option value="NACIONAL">NACIONAL</option>
                                <option value="REGIONAL">REGIONAL</option>
                                <option value="INTERNACIONAL">INTERNACIONAL</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre de la persona:</label>
                            <input id="nombre" name="nombrePersona" maxlength="100" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="salario">Salario:</label>
                            <input id="salario" name="salario" type="number" min="1" class="form-control"/>
                        </div>
                        <label for="salario">Direccion:</label>
                        <input id="direccion" name="direccion" maxlength="150" class="form-control"/>
                        <br>
                        <button class="btn btn-success">Crear solicitud</button>
                    </form>
                        
                </div>
                        
            </section>
        </main>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
