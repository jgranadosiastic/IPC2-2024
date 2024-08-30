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
        
       
        <p>este es un parrafo</p>
        
        
        <form action="show-message.jsp">
            <label >Mensaje:</label>
            <input id="msjId" name="msjName" type="text"/>
            <input id="count" name="count" type="number"/>
            <button type="submit" id="btn1" name="btn1N">Procesar mensaje</button>
        </form>
        
        
        <%= request.getParameter("msjName")%>
        
    </body>
</html>
