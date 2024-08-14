/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc.java.ipc2;

import static com.google.protobuf.JavaFeaturesProto.java;
import com.jgranados.jdbc.java.ipc2.estudiante.Estudiante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class EjemploConexionMysql {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/control_cursos";
    private static final String USER = "rootdba";
    private static final String PASSWORD = "12345";

    private Connection connection;

    public EjemploConexionMysql() {
        try {
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
            System.out.println("Esquema: " + connection.getSchema());
        } catch (SQLException e) {
            System.out.println("Error al connectar a la DB");
            e.printStackTrace();
        }

    }

    public void guardarEstudiante() {
        Estudiante estudiante = new Estudiante();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba Carnet");
        estudiante.setCarnet(scanner.nextLine());

        System.out.println("Escriba Nombre");
        estudiante.setNombre(scanner.nextLine());

        System.out.println("Escriba Apellidos");
        estudiante.setApellidos(scanner.nextLine());

        System.out.println("Escriba fecha nacimiento yyyy-MM-dd");
        estudiante.setFechaNacimiento(scanner.nextLine());

        String insert = "INSERT INTO estudiante (carnet, nombre, apellidos, fecha_nacimiento) "
                + "values('" + estudiante.getCarnet() + "','"
                + estudiante.getNombre() + "','" + estudiante.getApellidos()
                + "','" + estudiante.getFechaNacimiento() + "')";

        try {

            Statement statementInsert = connection.createStatement();
            int rowsAffected = statementInsert.executeUpdate(insert);
            System.out.println("Rows affected> " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error al insertar a la DB");
            e.printStackTrace();
        }
    }

    public void consultarEstudiantes() {
        try {
            String select = "SELECT * FROM estudiante";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            while (resultSet.next()) {
                System.out.println("Datos estudiante");
                System.out.println("Carnet: " + resultSet.getString("carnet"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Apellidos: " + resultSet.getString("apellidos"));
                System.out.println("Fecha Nacimiento: "
                        + resultSet.getDate("fecha_nacimiento").toLocalDate());
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
            e.printStackTrace();
        }
    }
    
    public void consultarEstudiantesFiltrando() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ingrese carnet:");
            String carnet = scanner.nextLine();
            
            System.out.println("ingrese apellido:");
            String apellido = scanner.nextLine();
            
            String select = "SELECT * FROM estudiante where carnet = '" + carnet + 
                    "' and apellidos like '%" + apellido + "%'";
            Statement statementInsert = connection.createStatement();
            ResultSet resultSet = statementInsert.executeQuery(select);

            while (resultSet.next()) {
                System.out.println("Datos estudiante");
                System.out.println("Carnet: " + resultSet.getString("carnet"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Apellidos: " + resultSet.getString("apellidos"));
                System.out.println("Fecha Nacimiento: "
                        + resultSet.getDate("fecha_nacimiento").toLocalDate());
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar a la DB");
            e.printStackTrace();
        }
    }

    public void procesoTransaccion() {
        String statementUpdateStr = "update asignacion set aprobado = true where carnet_estudiante = '200954782'";
        String statementUpdateCarnetStr = "update estudiante set carnet = '200413171' where carnet = '54125'";
        try {
            connection.setAutoCommit(false);
            Statement stmtnUpdate = connection.createStatement();
            stmtnUpdate.executeUpdate(statementUpdateStr);

            Statement stmtnUpdateCarnet = connection.createStatement();
            stmtnUpdateCarnet.executeUpdate(statementUpdateCarnetStr);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Hay un error en la transaccion");
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("Error en rollback");
            }
            
        }

    }

}
