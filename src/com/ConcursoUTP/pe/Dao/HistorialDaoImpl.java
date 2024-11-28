package com.ConcursoUTP.pe.Dao;

import com.ConcursoUTP.pe.Model.Historial;
import com.ConcursoUTP.pe.Utils.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistorialDaoImpl extends Conexion implements HistorialDao {

    @Override
    public void registra(Historial t) throws Exception {
        try {
            String sql = """
                         INSERT INTO public.historial(
                         \t id_puerto, fecha, hora, humedad)
                         \tVALUES (?, ?, ?, ?);""";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, t.getId_puerto());
            ps.setString(2, t.getFecha());
            ps.setString(3, t.getHora());
            ps.setInt(4, t.getHumedad());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }

    }

    @Override
    public List<Historial> listar(int id_Puerto) {
        int i =1;
        List<Historial> lst = new ArrayList<>();
        try {
            String sql = """
                         SELECT fecha, hora, humedad
                         \tFROM public.historial 
                         \twhere id_puerto = ?;""";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, id_Puerto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Historial h = new Historial();
                h.setId(i++);
                h.setFecha(rs.getString(1));
                h.setHora(rs.getString(2));
                h.setHumedad(rs.getInt(3));
                lst.add(h);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            conectar();
        }
        return lst;
    }

    @Override
    public void modificar(Historial t, String option) throws Exception {
    }

    @Override
    public void eliminar(int id) throws Exception {
    }

    @Override
    public List<Historial> listarTodos() throws Exception {
        return null;
    }

    @Override
    public Historial objet(int id) throws Exception {
        return null;
    }

    @Override
    public void eliminarporPuerto(int id_Puerto) {
        try {
            String sql = """
                         DELETE FROM public.historial
                         	WHERE id_puerto = ?;
                         """;
            
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, id_Puerto);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        } finally {
        Cerrar();
        }
    }
    

}
