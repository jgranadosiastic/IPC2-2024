/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.mvc.controllers;

import com.jgranados.jsp.app.backend.db.ClaseDBSolicitudes;
import com.jgranados.jsp.app.backend.exceptions.UserDataInvalidException;
import com.jgranados.jsp.app.backend.solicitudes.CreadorSolicitudes;
import com.jgranados.jsp.app.backend.solicitudes.Solicitud;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
@WebServlet(name = "ControladorSolicitudesServlet", urlPatterns = {"/mvc/solicitudes/solicitudes-servlet"})
public class ControladorSolicitudesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreadorSolicitudes creadorSolicitudes = new CreadorSolicitudes();
        try {
            Solicitud solicitudCreada = creadorSolicitudes.crearSolicitud(req);

            // para compartir un modelo y usar redirect para mostrar una vista jsp
            /*req.getSession().setAttribute("solicitudCreada", solicitudCreada);
            resp.sendRedirect(req.getContextPath() + "/solicitudes/crear-solicitud.jsp?codigo=" + solicitudCreada.getCodigo());*/
            // para compartir un modelo y usar forward para mostrar una vista jsp
            req.setAttribute("solicitudCreada", solicitudCreada);
            req.getRequestDispatcher("/solicitudes/crear-solicitud.jsp")
                    .forward(req, resp);
        } catch (UserDataInvalidException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClaseDBSolicitudes dbSolicitudes = new ClaseDBSolicitudes();
        if (getAll(request)) {
            List<Solicitud> list = dbSolicitudes.obtenerSolicitudes();

            request.setAttribute("solicitudes", list);
            request.getRequestDispatcher("/solicitudes/listar-solicitudes.jsp")
                    .forward(request, response);
        } else {
            Optional<Solicitud> solicitud = dbSolicitudes.obtener(request.getParameter("codigo"));
            if (solicitud.isPresent()) {
                request.setAttribute("solicitud", solicitud.get());
                request.getRequestDispatcher("/solicitudes/editar-solicitud.jsp")
                        .forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp?msg=No existe la solicitud con codigo: " + request.getParameter("codigo"));
            }
        }
    }

    private boolean getAll(HttpServletRequest request) {
        return request.getParameter("codigo") == null || request.getParameter("codigo").trim().isBlank();
    }

}
