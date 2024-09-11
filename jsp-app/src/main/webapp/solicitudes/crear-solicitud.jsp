<%-- 
    Document   : crear-solicitud
    Created on : Sep 5, 2024, 1:02:44 PM
    Author     : jose
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitud Creada</title>
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="/includes/header.jsp"/>
        <main>
            <section class="section">
                <div class="container">
                    <h1>Solicitud creada, Codigo de solicitud: ${param.codigo} ${sessionScope.solicitudCreada} ${solicitudCreada}</h1>
                </div>
            </section>
        </main>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
