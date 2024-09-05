<%-- 
    Document   : index
    Created on : Aug 29, 2024, 3:41:04 PM
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <a href="message.jsp">ir a mensajes</a>
         <a href="solicitudes/nueva-solicitud.jsp">crear solicitud</a>
        <%
        
        int i = 0;
        for (i = 0; i < 10; i++) {
        %>
        <h1>Hello World!</h1>
        <%}%>
        <p>este es un parrafo</p>
        
        
       
        
    </body>
</html>
