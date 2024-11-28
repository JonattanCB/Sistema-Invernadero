package com.ConcursoUTP.pe.Service;

import com.ConcursoUTP.pe.Service.Inter.IArduino;
import com.ConcursoUTP.pe.Service.Inter.IInicio;
import com.ConcursoUTP.pe.Service.Inter.IPlantas;
import com.ConcursoUTP.pe.Service.Inter.IPuertos;
import com.ConcursoUTP.pe.Service.Inter.Impl.InicioImpl;
import com.ConcursoUTP.pe.Service.Inter.ServicioFabrica;


public class InicioFabrica implements ServicioFabrica{

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
       return new InicioImpl();
    }

    @Override
    public IArduino getArduino() {
        return null;
    }
    
}
