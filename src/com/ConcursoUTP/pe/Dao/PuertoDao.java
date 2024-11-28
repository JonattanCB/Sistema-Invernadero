package com.ConcursoUTP.pe.Dao;

import com.ConcursoUTP.pe.Model.InformePuerto;
import com.ConcursoUTP.pe.Model.Puerto;
import java.util.List;

public interface PuertoDao extends CRUD<Puerto> {
    
    InformePuerto setPuerto(int id);
    
    int setTemperatura(String COM);
    
    List<String> PuertosCom(); 
    
    List<Integer> listaIDPuerto(int id_planta);
    
    int setIdPuerto(String COM);
    
    boolean Repeticion(String COM);
    
    boolean RepeticionEdit(String COMACTUal, int id);
    
    void eliminarPlantaPuerto(int idPlanta);
    
}
