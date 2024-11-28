package com.ConcursoUTP.pe.Service.Inter.Impl;

import com.ConcursoUTP.pe.Service.Inter.IInicio;
import com.ConcursoUTP.pe.View.Index;
import javax.swing.SwingUtilities;


public class InicioImpl implements IInicio {

    
    //=============================== Class ===================
    //=========================================================
    @Override
    public void initDasboard(Index index) {
        validacion(index);
        barraespera(index);
    }
    
    //=============================== Extens ===================
    //=========================================================
    
    private void validacion(Index index){
        index.iconCargador.setVisible(true);
        index.txtCargador.setVisible(true);
        index.jProgressBar.setVisible(true);
        index.jProgressBar.setValue(0);
    }
    
    private void barraespera(Index index){
        Thread progress = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                index.jProgressBar.setValue(i);
                caminar(index,i);
            }
            
            SwingUtilities.invokeLater(() -> {
                index.TabbedPanel_Principal.setSelectedIndex(1);
            });
        });
        
        progress.start();
    }
    
    private void caminar(Index index, int i){
        int x = index.iconCargador.getX();
        int y = index.iconCargador.getY();
        if (i<95) {
            index.iconCargador.setLocation(x+4,y);
        }
        
    }
    
    
}
