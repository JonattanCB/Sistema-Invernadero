package com.ConcursoUTP.pe.Dao;

import com.ConcursoUTP.pe.Model.InformePuerto;
import com.ConcursoUTP.pe.Model.Puerto;
import com.ConcursoUTP.pe.Utils.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PuertoDaoImpl extends Conexion implements PuertoDao {

    @Override
    public void registra(Puerto t) throws Exception {
        try {
            String sql = """
                         INSERT INTO public.puerto(
                         \tid_planta, nombre, descripcion, tem_humedad, "COM")
                         \tVALUES (?, ?, ?, ?, ?);""";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, t.getId_planta());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getDescripcion());
            ps.setInt(4, t.getTem_humedad());
            ps.setString(5, t.getCOM());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("erro: " + e);
        } finally {
            Cerrar();
        }
    }

    @Override
    public void modificar(Puerto t, String option) throws Exception {
        option = null;
        try {
            String sql = """
                         UPDATE public.puerto
                         \tSET id_planta=?, nombre=?, descripcion=?, tem_humedad=?, "COM"=?
                         \tWHERE id=? ;""";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, t.getId_planta());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getDescripcion());
            ps.setInt(4, t.getTem_humedad());
            ps.setString(5, t.getCOM());
            ps.setInt(6, t.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        try {
            String sql = """
                        DELETE FROM public.puerto
                        \tWHERE id = ? ;""";
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
    public List<Puerto> listarTodos() throws Exception {
        List<Puerto> lst = new ArrayList<>();
        String sql = """
                     SELECT puerto.id, planta.nombre , puerto.nombre, puerto."COM"
                     \tFROM public.puerto
                     \tinner join public.planta ON planta.id = puerto.id_planta 
                     order by id asc
                     """;
        PreparedStatement ps = conectar().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Puerto p = new Puerto();
            p.setId(rs.getInt(1));
            p.setN_Planta(rs.getString(2));
            p.setNombre(rs.getString(3));
            p.setCOM(rs.getString(4));
            lst.add(p);
        }
        return lst;
    }

    @Override
    public Puerto objet(int id) throws Exception {
        Puerto p = new Puerto();
        try {
            String sql = """
                         SELECT id, id_planta, nombre, descripcion, tem_humedad, "COM"
                         \tFROM public.puerto WHERE id = ?;""";
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setId_planta(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setTem_humedad(rs.getInt(5));
                p.setCOM(rs.getString(6));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
        return p;
    }

    @Override
    public InformePuerto setPuerto(int id) {
        InformePuerto p = new InformePuerto();
        try {
            String sql = """
                         SELECT puerto.id , puerto.nombre , puerto.descripcion,
                         puerto.tem_humedad , planta.nombre , planta."Foto" ,puerto."COM"  FROM public.puerto
                         INNER JOIN planta on puerto.id_planta = planta.id
                         Where puerto.id = ? """;
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setTemperatura(rs.getInt(4));
                p.setNombrePlanta(rs.getString(5));
                p.setFotoOuput(rs.getBytes(6));
                p.setCOM(rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
        return p;
    }

    @Override
    public int setTemperatura(String COM) {
        int temp = 0;
        try {
            String sql = """
                         SELECT tem_humedad FROM public.puerto where puerto."COM" = ? ; """;
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, COM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                temp = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
        return temp;
    }

    @Override
    public List<String> PuertosCom() {
        List<String> Puertos = new ArrayList<>();
        try {
            String sql = """
                         SELECT "COM" FROM public.puerto ; """;
            PreparedStatement ps = conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String puerts = rs.getString(1);
                Puertos.add(puerts);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
        return Puertos;
    }

    @Override
    public int setIdPuerto(String COM) {
        int id = 0;
        try {
            String sql = """
                         SELECT id FROM public.puerto where puerto."COM" = ? ; """;
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, COM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            Cerrar();
        }
        return id;
    }

    @Override
    public boolean Repeticion(String COM) {
        boolean v = false;
        try {
            String sql ="""
                         SELECT "COM" FROM public.puerto ; """;
            PreparedStatement ps = conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(COM)) {
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
    public boolean RepeticionEdit(String COMACTUal, int id) {
       boolean v = false;
        try {
            String sql = """
                         SELECT id ,"COM" FROM public.puerto ; """;
            PreparedStatement ps = conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) != id) {
                    if (rs.getString(2).equalsIgnoreCase(COMACTUal)) {
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
    public void eliminarPlantaPuerto(int idPlanta) {
    try {
            String sql = """
                         DELETE FROM public.puerto
                         	WHERE id_planta = ? ;
                         """;
            
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, idPlanta);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        } finally {
        Cerrar();
        }
    }   

    @Override
    public List<Integer> listaIDPuerto(int id_planta) {
        List<Integer> lst = new ArrayList<>();
        try {
            String sql = """
                         SELECT id
                         	FROM public.puerto where id_planta = ?;
                         """;
            
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, id_planta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt(1);
                lst.add(id);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        } finally {
        Cerrar();
        }
        return lst;
    }
}
