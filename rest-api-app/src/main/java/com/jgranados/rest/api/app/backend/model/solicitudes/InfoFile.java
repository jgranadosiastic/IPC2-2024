/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.backend.model.solicitudes;

/**
 *
 * @author jose
 */
public class InfoFile {
    private String filePath;
    private String fileName;
    private String fileContentType;

    public InfoFile(String filePath, String fileName, String fileContentType) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileContentType = fileContentType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
    
    
    
}
