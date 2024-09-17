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
        <title>Upload file</title>
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <body>
        <jsp:include page="/includes/header.jsp"/>
        <main>
            <section class="section">
                <div class="container">
                    <h1>Download file</h1>
                    
                    <a href="${pageContext.servletContext.contextPath}/mvc/files/download-servlet?path=${param.path}&contentType=${param.contentType}&fileName=${param.fileName}">Descargar ${param.path}</a>
                        
                </div>
                        
            </section>
        </main>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>