package com.ConcursoUTP.pe.Service.Inter;

import com.ConcursoUTP.pe.View.Index;
import javax.swing.JTextField;


public interface IPlantas {
    
    void GoControlPanelPlanta(Index index);
    
    void GoNewPlanta(Index index);
    
    void GoEditPlanta(Index index,int id);
    
    void SelectFoto(Index index,String opcion);
    
    void addPlanta(Index index);
    
    void editPlanta(Index index);
    
    void delatePlanta(Index index, int id);
    
    void TablePlanta(Index index);
    
    void SearchPlanta(Index index);
    
    void validacionPlanta(String opcion, JTextField text);
    
}
