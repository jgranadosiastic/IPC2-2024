/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.mvc.controllers;

import com.jgranados.jsp.app.backend.exceptions.UserDataInvalidException;
import com.jgranados.jsp.app.backend.solicitudes.CreadorSolicitudes;
import com.jgranados.jsp.app.backend.solicitudes.Solicitud;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
}
