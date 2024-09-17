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
                    <h1>Upload file</h1>
                    <form method="POST" action="${pageContext.servletContext.contextPath}/mvc/files/upload-servlet"
                          enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="numSolicitud">Numero de solicitud:</label>
                            <input id="codigo" name="codigo" class="form-control" placeholder="Numero de solicitud"/>
                        </div>
                        <div class="form-group">
                            <label for="fileSolicitud">Archivo:</label>
                            <input type="file" id="fileSolicitud" name="fileSolicitud" class="form-control"/>
                        </div>
                        <br>
                        <button class="btn btn-success">Subir archivo</button>
                    </form>
                        
                </div>
                        
            </section>
        </main>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
