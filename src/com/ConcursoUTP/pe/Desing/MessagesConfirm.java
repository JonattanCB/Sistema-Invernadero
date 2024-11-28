package com.ConcursoUTP.pe.Desing;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MessagesConfirm {

    public boolean MessageOption(String Nombre, String Opcion, JPanel panel) {
        boolean solucion;
        int resultado = JOptionPane.showConfirmDialog(panel, MessageVerificar(Nombre, Opcion), "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        solucion = resultado == JOptionPane.YES_OPTION;
        return solucion;
    }

    private String MessageVerificar(String Nombre, String Opcion) {
        String mensaje = "";
        switch (Opcion) {
            case "dplanta" -> {
                mensaje = "Eliminar esta planta (ID:"+ Nombre +") resultará en la eliminación de puertos asignados y su historial. ¿Estás seguro?";
            }
            case "eplanta" -> {
                mensaje = "Editar esta planta (ID: "+Nombre+") conllevará algunas modificaciones en los puertos asignados. ¿Deseas proceder?";
            }
            case "dpuerto" -> {
                mensaje ="Eliminar este puerto  (ID:"+ Nombre +") resultará en la eliminación de  historial .¿Estás seguro?";
            }
            case "epuerto" -> {
                mensaje = "Editar este puerto (ID: "+Nombre+") conllevará algunas modificaciones en el historial. ¿Deseas proceder?";
            }
            default ->
                throw new AssertionError();
        }
        return mensaje;
    }

}
