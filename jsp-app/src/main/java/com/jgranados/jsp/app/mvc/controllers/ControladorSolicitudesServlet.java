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
            req.setAttribute("solicitudCreada", solicitudCreada);
            req.getSession().setAttribute("solicitudCreada", solicitudCreada);
            resp.sendRedirect("/jsp-app/solicitudes/crear-solicitud.jsp?codigo=" + solicitudCreada.getCodigo());
        } catch (UserDataInvalidException e) {
            e.printStackTrace();
        }
        
    }
}
