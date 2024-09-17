<%-- 
    Document   : show-message
    Created on : Aug 29, 2024, 4:03:10 PM
    Author     : jose
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <body>
    </body>
    <body>
        <jsp:include page="/includes/header.jsp"/>
        <main>
            <section class="section">
                <div class="container">

                    <div class="alert alert-danger" role="alert">
                        <%= request.getParameter("msg")%>
                    </div>
                </div>
            </section>
        </main>
        <jsp:include page="/includes/footer.jsp"/>
</html>
