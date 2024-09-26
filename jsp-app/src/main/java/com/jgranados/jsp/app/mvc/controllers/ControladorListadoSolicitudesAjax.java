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
@WebServlet(name = "ControladorListadoSolicitudesAjax", urlPatterns = {"/mvc/solicitudes/ajax/solicitudes-servlet"})
public class ControladorListadoSolicitudesAjax extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClaseDBSolicitudes dbSolicitudes = new ClaseDBSolicitudes();
        List<Solicitud> list = dbSolicitudes.obtenerSolicitudes();

        request.setAttribute("solicitudes", list);
        request.getRequestDispatcher("/solicitudes/ajax/listar-solicitudes-ajax.jsp")
                .forward(request, response);

    }

}
