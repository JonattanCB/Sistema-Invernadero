package com.ConcursoUTP.pe.Service.Inter;

import com.ConcursoUTP.pe.Desing.IDesing;
import com.ConcursoUTP.pe.View.Index;
import com.ConcursoUTP.pe.View.Infcom;
import java.util.List;
import javax.swing.JLabel;

public interface IArduino {
    
    List<String> PuertosCom();
    
    void regadadorAutomatico();
    
    void GoInfCom( Infcom ifcom, Index index, IDesing desing, int p);
    
}
