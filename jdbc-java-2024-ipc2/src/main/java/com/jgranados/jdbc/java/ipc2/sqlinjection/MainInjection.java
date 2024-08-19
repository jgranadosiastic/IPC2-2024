/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc.java.ipc2.sqlinjection;

/**
 *
 * @author jose
 */
public class MainInjection {
    public static void main(String[] args) {
        ConnectionInjection connectionInjection = new ConnectionInjection();
        
        connectionInjection.login();
        connectionInjection.loginSinInyeccionSQL();
    }
    
}
