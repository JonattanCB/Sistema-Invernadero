package com.ConcursoUTP.pe.Desing;

import com.ConcursoUTP.pe.View.Index;
import com.ConcursoUTP.pe.View.Infcom;
import javax.swing.JButton;

public interface IDesing {

    void init(Index index);
    
    void initInfCOM(Infcom infcom);
    
    void getLookandFell();

    void tableButtos(String Option, JButton btn);
    
}
