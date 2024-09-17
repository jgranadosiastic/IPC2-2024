<%-- 
    Document   : crear-solicitud
    Created on : Sep 5, 2024, 1:02:44 PM
    Author     : jose
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitudes</title>
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="/includes/header.jsp"/>
        <main>
            <section class="section">
                <div class="container">
                    <form method="POST" action="${pageContext.servletContext.contextPath}/mvc/solicitudes/solicitudes-servlet">
                        <div class="form-group">
                            <label for="numSolicitud">Numero de solicitud:</label>
                            <p>${solicitud.codigo}</p>
                            <input type="hidden" name="codigo" value="${solicitud.codigo}"/>
                        </div>
                        <div class="form-group">
                            <label for="fecha">Fecha:</label>
                            <input type="date" id="fecha" name="fecha" class="form-control" value="${solicitud.fecha}"/>
                        </div>
                        <div class="form-group">
                            <label for="tipo">Tipo:</label>
                            <select id="tipo" name="tipo" class="form-control">
                                <option value="NACIONAL" ${solicitud.tipo eq 'NACIONAL' ? 'selected' : ''}>NACIONAL</option>
                                <option value="REGIONAL" ${solicitud.tipo eq 'REGIONAL' ? 'selected' : ''}>REGIONAL</option>
                                <option value="INTERNACIONAL" ${solicitud.tipo eq 'INTERNACIONAL' ? 'selected' : ''}>INTERNACIONAL</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre de la persona:</label>
                            <input id="nombre" name="nombrePersona" maxlength="100" class="form-control" value="${solicitud.nombrePersona}"/>
                        </div>
                        <div class="form-group">
                            <label for="salario">Salario:</label>
                            <input id="salario" name="salario" type="number" min="1" class="form-control" value="${solicitud.salario}"/>
                        </div>
                        <label for="salario">Direccion:</label>
                        <input id="direccion" name="direccion" maxlength="150" class="form-control" value="${solicitud.direccion}"/>
                        <br>
                        <input type="hidden" name="edit" value="1"/>
                        <button class="btn btn-success">Guardar solicitud</button>
                    </form>
                </div>
            </section>
        </main>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
