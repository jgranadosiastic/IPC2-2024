/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.backend.db;

import com.jgranados.jsp.app.backend.solicitudes.Solicitud;
import com.jgranados.jsp.app.backend.solicitudes.TipoSolicitudEnum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class ClaseDBSolicitudes {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/control_cursos";
    private static final String USER = "rootdba";
    private static final String PASSWORD = "12345";

    private Connection connection;

    private List<Solicitud> solicitudes;

    public ClaseDBSolicitudes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
            System.out.println("Esquema: " + connection.getSchema());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al connectar a la DB");
            e.printStackTrace();
        }

        Solicitud solicitud1 = new Solicitud();
        solicitud1.setCodigo("ABC-123");
        solicitud1.setNombrePersona("Persona solicitud1");
        solicitud1.setTipo(TipoSolicitudEnum.INTERNACIONAL);
        solicitud1.setFecha(LocalDate.of(2024, 7, 3));
        solicitud1.setSalario(25000f);
        solicitud1.setDireccion("Direccion solicitud 1");

        Solicitud solicitud2 = new Solicitud();
        solicitud2.setCodigo("ABC-456");
        solicitud2.setNombrePersona("Persona solicitud2");
        solicitud2.setTipo(TipoSolicitudEnum.REGIONAL);
        solicitud2.setFecha(LocalDate.of(2024, 8, 4));
        solicitud2.setSalario(35000f);
        solicitud2.setDireccion("Direccion solicitud 2");

        Solicitud solicitud3 = new Solicitud();
        solicitud3.setCodigo("ABC-789");
        solicitud3.setNombrePersona("Persona solicitud3");
        solicitud3.setTipo(TipoSolicitudEnum.NACIONAL);
        solicitud3.setFecha(LocalDate.of(2024, 9, 5));
        solicitud3.setSalario(15000f);
        solicitud3.setDireccion("Direccion solicitud 3");

        solicitudes = Arrays.asList(solicitud1, solicitud2, solicitud3);

    }

    public boolean existeSolicitud(String codigo) {
        // TODO
        return false;
    }

    public void crearSolicitud(Solicitud solicitud) {
        // TODO
    }

    public List<Solicitud> obtenerSolicitudes() {
        return solicitudes;
    }
    
    public Optional<Solicitud> obtener(String codigo) {
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getCodigo().equals(codigo)) {
                return Optional.of(solicitud);
            }
        }
        
        return Optional.empty();
    }
}
