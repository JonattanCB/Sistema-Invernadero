package com.ConcursoUTP.pe.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JS02
 */
public class Conexion {

    private final String url = "jdbc:postgresql://localhost:5432/proy_invernadero";
    private final String usuario = "postgres";
    private final String contraseña = "2002";
    protected Connection conn = null;

    public Connection conectar() {
        try {conn = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
        return conn;
    }

    public void Cerrar() {
        try { conn.close();
        } catch (SQLException e) {
            System.out.println("Error de cerrar Conexion: " + e.getMessage());
        }
    }
}
