package com.ConcursoUTP.pe.Model;

public class InformePuerto {
    
    private int id;
    
    private int temperatura;
    
    private String nombre;
    
    private String COM;
    
    private String descripcion;
    
    private String nombrePlanta;
    
    private byte[] fotoOuput;

    public InformePuerto() {
    }

    public InformePuerto(int id, int temperatura, String nombre, String COM, String descripcion, String nombrePlanta, byte[] fotoOuput) {
        this.id = id;
        this.temperatura = temperatura;
        this.nombre = nombre;
        this.COM = COM;
        this.descripcion = descripcion;
        this.nombrePlanta = nombrePlanta;
        this.fotoOuput = fotoOuput;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombrePlanta() {
        return nombrePlanta;
    }

    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }

    public byte[] getFotoOuput() {
        return fotoOuput;
    }

    public void setFotoOuput(byte[] fotoOuput) {
        this.fotoOuput = fotoOuput;
    }

    public String getCOM() {
        return COM;
    }

    public void setCOM(String COM) {
        this.COM = COM;
    }
}
