
package com.ConcursoUTP.pe.Service;

import com.ConcursoUTP.pe.Service.Inter.IArduino;
import com.ConcursoUTP.pe.Service.Inter.IInicio;
import com.ConcursoUTP.pe.Service.Inter.IPlantas;
import com.ConcursoUTP.pe.Service.Inter.IPuertos;
import com.ConcursoUTP.pe.Service.Inter.Impl.PlantasImpl;
import com.ConcursoUTP.pe.Service.Inter.ServicioFabrica;

/**
 *
 * @author JS02
 */
public class PlantasFabrica implements ServicioFabrica{

    @Override
    public IPlantas getPlantas() {
       return new PlantasImpl();
    }

    @Override
    public IPuertos getPuerto() {
       return null;
    }

    @Override
    public IInicio getInicio() {
       return  null;
    }

    @Override
    public IArduino getArduino() {
        return null;
    }
    
}
