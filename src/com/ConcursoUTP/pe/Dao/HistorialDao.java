package com.ConcursoUTP.pe.Dao;

import com.ConcursoUTP.pe.Model.Historial;
import java.util.List;

public interface HistorialDao extends CRUD<Historial>{
    
    List<Historial> listar(int id_Puerto); 
    
    void eliminarporPuerto (int id_Puerto);
    
}
