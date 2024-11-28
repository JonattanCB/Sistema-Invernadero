package com.ConcursoUTP.pe.Service;

import com.ConcursoUTP.pe.Service.Inter.IArduino;
import com.ConcursoUTP.pe.Service.Inter.IInicio;
import com.ConcursoUTP.pe.Service.Inter.IPlantas;
import com.ConcursoUTP.pe.Service.Inter.IPuertos;
import com.ConcursoUTP.pe.Service.Inter.Impl.ArduinoImpl;
import com.ConcursoUTP.pe.Service.Inter.ServicioFabrica;

public class ArduinoFabrica implements ServicioFabrica {

    @Override
    public IPlantas getPlantas() {
        return null;
    }

    @Override
    public IPuertos getPuerto() {
        return null;
    }

    @Override
    public IInicio getInicio() {
        return null;
    }

    @Override
    public IArduino getArduino() {
        return new ArduinoImpl();
    }

}
