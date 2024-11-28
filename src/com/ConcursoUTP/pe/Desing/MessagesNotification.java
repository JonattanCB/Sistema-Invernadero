package com.ConcursoUTP.pe.Desing;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MessagesNotification {
    
    public void MessageOption(JPanel panel, int opcion, String mensaje) {
        switch (opcion) {
            case 0 -> {
                MessageTrue(panel, mensaje);
            }
            case 1 -> {
                MessageAlert(panel, mensaje);
            }
            case 2 -> {
                MessageError(panel, mensaje);
            }
            default ->
                throw new AssertionError();
        }
    }
    
    private void MessageTrue(JPanel panel, String Opcion) {
        String mensaje = "";
        switch (Opcion) {
            case "fdatos" -> {
                mensaje = "";
            }
            default ->
                throw new AssertionError();
        }
        JOptionPane.showMessageDialog(panel, mensaje, "Message", JOptionPane.PLAIN_MESSAGE);
    }
    
    private void MessageAlert(JPanel panel, String Opcion) {
        String mensaje = "";
        switch (Opcion) {
            case "fdatos" -> {
                mensaje = "Por favor, complete todos los campos antes de guardar";
            }
            case "rdatos" ->{
                mensaje = "¡Alerta! El nombre de la planta ya está registrado";
            }
            default ->
                throw new AssertionError();
        }
        JOptionPane.showMessageDialog(panel, mensaje, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    private void MessageError(JPanel panel, String Opcion) {
        String mensaje = "";
        switch (Opcion) {
            case "vfallida" -> {
                mensaje = "";
            }
            default ->
                throw new AssertionError();
        }
        JOptionPane.showMessageDialog(panel, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
}
