package com.ConcursoUTP.pe.Dao;

import com.ConcursoUTP.pe.Model.Planta;
import com.ConcursoUTP.pe.Utils.Conexion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlantaDaoImpl extends Conexion implements PlantaDao {

    @Override
    public void registra(Planta t) throws Exception {
        try {
            FileInputStream inputStream = new FileInputStream(t.getFotoInput());
            String query = """
                           INSERT INTO public.planta(
                           	 nombre, "Descripcion", "Foto")
                           	VALUES (?, ?, ?);
                           """;
            PreparedStatement ps = conectar().prepareStatement(query);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDescripcion());
            ps.setBinaryStream(3, inputStream, t.getFotoInput().length());
            ps.execute();
        } catch (FileNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
    }

    @Override
    public void modificar(Planta t, String option) throws Exception {
        switch (option) {
            case "sinFoto" -> {
                try {
                    String sql = """
                                 UPDATE public.planta
                                 \tSET nombre=?, "Descripcion"=?
                                 \tWHERE id = ?;""";
                    PreparedStatement ps = conectar().prepareStatement(sql);
                    ps.setString(1, t.getNombre());
                    ps.setString(2, t.getDescripcion());
                    ps.setInt(3, t.getId());
                    ps.execute();
                } catch (SQLException e) {
                    System.out.println("Error: " + e);
                } finally {
                    Cerrar();
                }
            }
            case "conFoto" -> {
                try {
                    FileInputStream inputStream = new FileInputStream(t.getFotoInput());
                    String sql = """
                                 UPDATE public.planta
                                 \tSET nombre=?, "Descripcion"=?, "Foto"=?
                                 \tWHERE id = ?;""";
                    PreparedStatement ps = conectar().prepareStatement(sql);
                    ps.setString(1, t.getNombre());
                    ps.setString(2, t.getDescripcion());
                    ps.setBinaryStream(3, inputStream, t.getFotoInput().length());
                    ps.setInt(4, t.getId());
                    ps.execute();
                } catch (FileNotFoundException | SQLException e) {
                    System.out.println("Error: " + e);
                } finally {
                    Cerrar();
                }
            }

            default ->
                throw new AssertionError();
        }

    }

    @Override
    public void eliminar(int id) throws Exception {
        try {
            String sql = """
                         DELETE FROM public.planta
                         \tWHERE id = ?;""";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
    }

    @Override
    public List<Planta> listarTodos() throws Exception {
        List<Planta> lst = new ArrayList<>();
        try {
            String sql = "SELECT id, nombre, \"Descripcion\" FROM public.planta order by id asc ;";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Planta planta = new Planta();
                planta.setId(rs.getInt(1));
                planta.setNombre(rs.getString(2));
                planta.setDescripcion(rs.getString(3));
                lst.add(planta);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
        return lst;
    }

    @Override
    public Planta objet(int id) throws Exception {
        Planta planta = new Planta();
        try {
            String sql = """
                         SELECT id, nombre, "Descripcion", "Foto"
                         \tFROM public.planta Where id = ?  ;""";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                planta.setId(rs.getInt(1));
                planta.setNombre(rs.getString(2));
                planta.setDescripcion(rs.getString(3));
                planta.setFotoOuput(rs.getBytes(4));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
        return planta;
    }

    @Override
    public boolean Repeticion(String nombreActual) {
        boolean v = false;
        try {
            String sql = "SELECT nombre FROM public.planta;";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(nombreActual)) {
                    v = true;
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
        return v;
    }

    @Override
    public boolean RepeticionEdit(String nombreActual, int id) {
        boolean v = false;
        try {
            String sql = "SELECT id, nombre FROM public.planta;";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) != id) {
                    if (rs.getString(2).equalsIgnoreCase(nombreActual)) {
                        v = true;
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
        return v;
    }

    @Override
    public List<Planta> getNombres() {
        List<Planta> lst = new ArrayList<>();
        try {
            String sql = "SELECT id, nombre FROM public.planta;";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Planta p = new Planta();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                lst.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        } finally {
            Cerrar();
        }
        return lst;
    }

}
