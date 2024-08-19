/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc.java.ipc2.sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class ConnectionInjection {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/sql_inject";
    private static final String USER = "rootdba";
    private static final String PASSWORD = "12345";

    private Connection connection;

    public ConnectionInjection() {
        try {
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
            System.out.println("Esquema: " + connection.getSchema());
        } catch (SQLException e) {
            System.out.println("Error al connectar a la DB");
            e.printStackTrace();
        }

    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Ingrese password: ");
        String password = scanner.nextLine();

        String loginStatementStr = "select * from usuario where nombre_usuario = '"
                + nombreUsuario + "' and password = '"
                + password + "';";

        try {
            Statement loginStatement = connection.createStatement();
            ResultSet resultSet = loginStatement.executeQuery(loginStatementStr);
            if (resultSet.next()) {
                System.out.println("Login exitoso!!!!!");
                System.out.println("Query usada:");
                System.out.println(loginStatementStr);
            } else {
                System.out.println("Usuario o password incorrectos!");
                System.out.println(loginStatementStr);
            }
        } catch (SQLException e) {
            System.out.println(loginStatementStr);
            System.out.println("Error en login");
            e.printStackTrace();
        }

    }

    public void loginSinInyeccionSQL() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Ingrese password: ");
        String password = scanner.nextLine();

        String loginStatementStr = "select * from usuario where nombre_usuario = ? and passwrod = ?";

        try {
            PreparedStatement loginStatement = connection.prepareStatement(loginStatementStr);
            loginStatement.setString(1, nombreUsuario);
            loginStatement.setString(2, password);

            ResultSet resultSet = loginStatement.executeQuery(loginStatementStr);
            if (resultSet.next()) {
                System.out.println("Login exitoso!!!!!");
                System.out.println("Query usada:");
                System.out.println(loginStatementStr);
            } else {
                System.out.println("Usuario o password incorrectos!");
                System.out.println(loginStatementStr);
            }
        } catch (SQLException e) {
            System.out.println(loginStatementStr);
            System.out.println("Error en login");
            e.printStackTrace();
        }

    }

}
