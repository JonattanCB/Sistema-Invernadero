package com.ConcursoUTP.pe.Model;

public class Historial {
    
    private int id;
    
    private int id_puerto;
    
    private String nombrePuerto;
    
    private String fecha;
    
    private String hora;
    
    private int humedad;

    public Historial() {
    }

    public Historial(int id, int id_puerto, String nombrePuerto, String fecha, String hora, int humedad) {
        this.id = id;
        this.id_puerto = id_puerto;
        this.nombrePuerto = nombrePuerto;
        this.fecha = fecha;
        this.hora = hora;
        this.humedad = humedad;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_puerto() {
        return id_puerto;
    }

    public void setId_puerto(int id_puerto) {
        this.id_puerto = id_puerto;
    }

    public String getNombrePuerto() {
        return nombrePuerto;
    }

    public void setNombrePuerto(String nombrePuerto) {
        this.nombrePuerto = nombrePuerto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }
    
}
