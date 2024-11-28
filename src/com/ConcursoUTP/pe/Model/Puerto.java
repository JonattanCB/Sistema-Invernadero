package com.ConcursoUTP.pe.Model;

public class Puerto {

    private int id;

    private int id_planta;

    private int tem_humedad;

    private String nombre;

    private String descripcion;

    private String COM;

    private String N_Planta;

    public Puerto() {
    }

    public Puerto(int id, int id_planta, int tem_humedad, String nombre, String descripcion, String COM, String N_Planta) {
        this.id = id;
        this.id_planta = id_planta;
        this.tem_humedad = tem_humedad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.COM = COM;
        this.N_Planta = N_Planta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_planta() {
        return id_planta;
    }

    public void setId_planta(int id_planta) {
        this.id_planta = id_planta;
    }

    public int getTem_humedad() {
        return tem_humedad;
    }

    public void setTem_humedad(int tem_humedad) {
        this.tem_humedad = tem_humedad;
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

    public String getCOM() {
        return COM;
    }

    public void setCOM(String COM) {
        this.COM = COM;
    }

    public String getN_Planta() {
        return N_Planta;
    }

    public void setN_Planta(String N_Planta) {
        this.N_Planta = N_Planta;
    }

}
