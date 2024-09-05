/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.backend.solicitudes;

import com.jgranados.jsp.app.backend.db.ClaseDBSolicitudes;
import com.jgranados.jsp.app.backend.exceptions.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author jose
 */
public class CreadorSolicitudes {
    
    private ClaseDBSolicitudes db = new ClaseDBSolicitudes();

    public Solicitud crearSolicitud(HttpServletRequest req) throws UserDataInvalidException {
        Solicitud nuevaSolicitud = extraerYValidar(req);
        if (db.existeSolicitud(nuevaSolicitud.getCodigo())) {
            throw new UserDataInvalidException("Codigo de solicitud ya existente!");
        }
        
        db.crearSolicitud(nuevaSolicitud);
        
        return nuevaSolicitud;
    }

    private Solicitud extraerYValidar(HttpServletRequest req) throws UserDataInvalidException {
        Solicitud nuevaSolicitud = new Solicitud();

        try {
            nuevaSolicitud.setCodigo(req.getParameter("codigo"));
            nuevaSolicitud.setFecha(LocalDate.parse(req.getParameter("fecha")));
            nuevaSolicitud.setTipo(TipoSolicitudEnum.valueOf(req.getParameter("tipo")));
            nuevaSolicitud.setNombrePersona(req.getParameter("nombrePersona"));
            nuevaSolicitud.setSalario(Float.parseFloat(req.getParameter("salario")));
            nuevaSolicitud.setDireccion(req.getParameter("direccion"));
        } catch (DateTimeParseException | IllegalArgumentException
                | NullPointerException e) {
            throw new UserDataInvalidException("Error en los datos enviados");
        }
        
        if (nuevaSolicitud.isValid()) {
            return nuevaSolicitud;
        }
        
        throw new UserDataInvalidException("Error en los datos enviados");
    }
}
