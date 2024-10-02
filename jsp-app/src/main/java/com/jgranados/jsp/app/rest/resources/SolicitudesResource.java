/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.rest.resources;

import com.jgranados.jsp.app.backend.db.ClaseDBSolicitudes;
import com.jgranados.jsp.app.backend.solicitudes.Solicitud;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author jose
 */
@Path("solicitudes")
public class SolicitudesResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSolicitudes() {
        ClaseDBSolicitudes dbSolicitudes = new ClaseDBSolicitudes();
        List<Solicitud> solicitudes = dbSolicitudes.obtenerSolicitudes();
        
        return Response.ok(solicitudes).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSolicitud(Solicitud solicitud) {
        ClaseDBSolicitudes dbSolicitudes = new ClaseDBSolicitudes();
        dbSolicitudes.crearSolicitud(solicitud);
        
        return Response.status(Response.Status.CREATED).build();
    }
}
