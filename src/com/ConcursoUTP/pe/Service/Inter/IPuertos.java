package com.ConcursoUTP.pe.Service.Inter;

import com.ConcursoUTP.pe.View.Index;
import javax.swing.JTextField;

public interface IPuertos {
    
    void GoControlPanelPuerto(Index index);
    
    void GoNewPuerto(Index index);
    
    void GoEditPuerto(Index index, int id);
    
    void addNewPuerto(Index index);
    
    void tablePuerto(Index index);
    
    void SearchPuerto(Index index);
    
    void DeletePuerto(Index index, int id);
    
    void EditPuerto(Index index);
    
    void validacionPuerto(String opcion, JTextField text);
    
}
