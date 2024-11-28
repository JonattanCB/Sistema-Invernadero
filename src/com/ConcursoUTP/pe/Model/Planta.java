package com.ConcursoUTP.pe.Model;

import java.io.File;

public class Planta {

    private int id;

    private String nombre;

    private String descripcion;

    private File fotoInput;

    private byte[] fotoOuput;
    
    public Planta() {
    }

    public Planta(int id, String nombre, String descripcion, File fotoInput, byte[] fotoOuput) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoInput = fotoInput;
        this.fotoOuput = fotoOuput;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public File getFotoInput() {
        return fotoInput;
    }

    public void setFotoInput(File fotoInput) {
        this.fotoInput = fotoInput;
    }

    public byte[] getFotoOuput() {
        return fotoOuput;
    }

    public void setFotoOuput(byte[] fotoOuput) {
        this.fotoOuput = fotoOuput;
    }
    
}