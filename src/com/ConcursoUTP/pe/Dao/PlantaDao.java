package com.ConcursoUTP.pe.Dao;

import com.ConcursoUTP.pe.Model.Planta;
import java.util.List;

public interface PlantaDao extends CRUD<Planta> {
    
    boolean Repeticion(String nombreActual);
    
    boolean RepeticionEdit(String nombreActual, int id);
    
    List<Planta> getNombres();
    
}
