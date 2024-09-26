<%-- 
    Document   : header
    Created on : Sep 10, 2024, 8:09:01 PM
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a href="${pageContext.servletContext.contextPath}/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                <span class="fs-4">Simple header</span>
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="${pageContext.servletContext.contextPath}/solicitudes/nueva-solicitud.jsp" class="nav-link" aria-current="page">Nueva Solicitud</a></li>
                <li class="nav-item"><a href="${pageContext.servletContext.contextPath}/mvc/solicitudes/solicitudes-servlet" class="nav-link">Listado solicitudes</a></li>
                <li class="nav-item"><a href="${pageContext.servletContext.contextPath}/solicitudes/ajax/ver-solicitudes.jsp" class="nav-link">Listado solicitudes con ajax</a></li>
                <li class="nav-item"><a href="${pageContext.servletContext.contextPath}/files/upload-file.jsp" class="nav-link">Upload file</a></li>
                <li class="nav-item"><a href="#" class="nav-link">FAQs</a></li>
                <li class="nav-item"><a href="#" class="nav-link">About</a></li>
            </ul>
        </header>
    </div>