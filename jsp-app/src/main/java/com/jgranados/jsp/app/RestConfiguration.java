/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 *
 * @author jose
 */
@ApplicationPath("api/v1")
public class RestConfiguration extends Application {
    /*
    public static final ObjectMapper objectMapper = JsonMapper.builder()
    .findAndAddModules()
    .build();
    
    private static final ObjectMapper mapper = JsonMapper.builder()
    .addModule(new JavaTimeModule())
    .build();
    
    private static final ObjectMapper mapper2 = new ObjectMapper().registerModule(new JavaTimeModule());*/
}

