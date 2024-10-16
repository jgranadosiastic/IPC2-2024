/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.restapi.resources;

import com.jgranados.rest.api.app.backend.model.solicitudes.InfoFile;
import com.jgranados.rest.api.app.backend.model.solicitudes.Solicitud;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author jose
 */
@Path("files-example")
public class UploadFileResource {

    public static final String PATH = "/home/jose/server/";

    @POST
    @Path("v1")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFileV1(
            @FormDataParam("nombre") String nombre,
            @FormDataParam("fileObject") FormDataBodyPart bodyPart,
            @FormDataParam("fileObject") InputStream uploadedInputStream,
            @FormDataParam("fileObject") FormDataContentDisposition fileDetails,
            @QueryParam(value = "data") String data) {

        InfoFile infoFile = new InfoFile(PATH + fileDetails.getFileName(), fileDetails.getFileName(), bodyPart.getMediaType().toString());

        saveFile(uploadedInputStream, infoFile.getFilePath());
        
        
        
        System.out.println("upload file version 1. Data: " + data);
        

        return Response.ok(infoFile).status(Response.Status.CREATED).build();
    }
    
    @POST
    @Path("v2")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFileV2(FormDataMultiPart multipart, @QueryParam(value = "data") String data) {
        FormDataBodyPart part = multipart.getField("fileObject");
        
        InfoFile infoFile = new InfoFile(PATH + part.getFileName().get(), part.getFileName().get(), part.getMediaType().toString());
        saveFile(part.getContent(), infoFile.getFilePath());
        System.out.println("upload file version 2. Data: " + data);

        return Response.ok(infoFile).status(Response.Status.CREATED).build();
    }

    private void saveFile(InputStream uploadedInputStream, String fileLocation) {
        // Save the file 
        try {
            OutputStream out = new FileOutputStream(new File(fileLocation));
            byte[] buffer = new byte[1024];
            int bytes = 0;
            while ((bytes = uploadedInputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytes);
            }
            out.flush();
            out.close();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }
}
