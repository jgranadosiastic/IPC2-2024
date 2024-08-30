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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Show message</h1>
        <p><%= request.getParameter("msjName")%></p>
        <c:if test="${param.count != null}">
            veces: ${param.count}
            <%
                int count = Integer.valueOf(request.getParameter("count"));
                for (int i = 0; i < count; i++) {
            %>
            <p><%= request.getParameter("msjName")%></p>
            <%
                }
            %>
        </c:if>
    </body>
</html>
