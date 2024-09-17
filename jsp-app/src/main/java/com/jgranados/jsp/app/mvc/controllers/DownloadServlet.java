/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.jsp.app.mvc.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author jose
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/mvc/files/download-servlet"})
public class DownloadServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getParameter("path");
        String fileType = request.getParameter("contentType");
        String fileName = request.getParameter("fileName");
        try (BufferedInputStream fileStream = new BufferedInputStream(new FileInputStream(path))) {
            response.setContentType(fileType);
            response.setHeader("Content-disposition", "attachment; filename="+fileName);
            int data = fileStream.read();
            while (data > -1) {
                response.getOutputStream().write(data);
                data = fileStream.read();
            }
        }
    }

}
