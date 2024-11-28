package com.ConcursoUTP.pe.Service;

import com.ConcursoUTP.pe.Service.Inter.ServicioFabrica;

public class FabricaServicio {
    public static  ServicioFabrica getFactors(String option){
        if (option.equalsIgnoreCase("planta")) {
            return new PlantasFabrica();
        }else if (option.equalsIgnoreCase("puerto")) {
            return new PuertoFabrica();
        }else if(option.equalsIgnoreCase("inicio")){
            return new InicioFabrica();
        }else if(option.equalsIgnoreCase("arduino")){
            return new ArduinoFabrica();
        }
        
        return null;
    }
}
