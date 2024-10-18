/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.restapi.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author jose
 */
@Path("files-example")
public class DownloadFileResource {

    @GET
    @Path("download")
    public Response downloadPdfFile( // estos datos por lo general  se obtienen 
            // en el lado del servidor porque se almacenan en la DB
            @QueryParam("pathFile") String pathFile,
            @QueryParam("fileName") String fileName) {


        /*try (InputStream fileStream = Files.newInputStream(Paths.get(pathFile));) {
            return Response
                    .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                    .header("content-disposition", "attachment; filename = " + fileName)
                    .build();
        } catch (IOException e) {
            throw new WebApplicationException("File Not Found !!");
        }*/
        StreamingOutput fileStream = (java.io.OutputStream output) -> {
            try {
                java.nio.file.Path path = Paths.get(pathFile);
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception e) {
                throw new WebApplicationException("File Not Found !!");
            }
        };

        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename = " + fileName)
                .build();
    }

}
