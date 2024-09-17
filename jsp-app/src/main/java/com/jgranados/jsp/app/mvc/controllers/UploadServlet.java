/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.jsp.app.mvc.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author jose
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/mvc/files/upload-servlet"})
@MultipartConfig(location = "/tmp")
public class UploadServlet extends HttpServlet {

    public static final String PATH = "/home/jose/server";

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart = request.getPart("fileSolicitud");
        String fileName = filePart.getName();
        String fileSName = filePart.getSubmittedFileName();
        String fileContentType = filePart.getContentType();
        InputStream fileStream = filePart.getInputStream();
        System.out.println(fileName);
        System.out.println(fileSName);
        System.out.println(fileContentType);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(fileStream))) {
            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
            String filePath = PATH + "/" + fileSName;
            filePart.write(filePath);

            request.getRequestDispatcher("/files/download-file.jsp?path=" + filePath + "&contentType=" + fileContentType + "&fileName=" + fileSName)
                    .forward(request, response);
        } catch (Exception ex) {
            // manejo de error
        }
    }

}
