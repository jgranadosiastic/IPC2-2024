<%-- 
    Document   : crear-solicitud
    Created on : Sep 5, 2024, 1:02:44 PM
    Author     : jose
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
                    <c:forEach items="${solicitudes}" var="solicitud">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${solicitud.nombrePersona}</h5>
                            <h6 class="card-subtitle mb-2 text-body-secondary">${solicitud.codigo}</h6>
                            <h6 class="card-subtitle mb-2 text-body-secondary">${solicitud.tipo}</h6>
                            <h6 class="card-subtitle mb-2 text-body-secondary">${solicitud.fecha}</h6>
                            <h6 class="card-subtitle mb-2 text-body-secondary">${solicitud.salario}</h6>
                            <p class="card-text">${solicitud.direccion}</p>
                            <a href="${pageContext.servletContext.contextPath}/mvc/solicitudes/solicitudes-servlet?codigo=${solicitud.codigo}" class="card-link">Editar</a>
                            <a href="#" class="card-link">Eliminar</a>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </section>
        </main>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
