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
                    <div class="row">
                        <div class="col-md-12">
                            <button type="button" class="btn btn-primary btn-lg btn-block" onclick="ajaxWithoutJQuery('${pageContext.request.contextPath}')">Presioname</button>
                            <button type="button" class="btn btn-primary btn-lg btn-block" onclick="ajaxWithJQuery('${pageContext.request.contextPath}')">Presioname con jquery</button>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12" id="ajax-target">
                            ajax target
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <jsp:include page="/includes/footer.jsp"/>
    </body>
</html>
