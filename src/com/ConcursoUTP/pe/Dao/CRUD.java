package com.ConcursoUTP.pe.Dao;

import java.util.List;

public interface CRUD<T> {

    void registra(T t) throws Exception; 
    
    void modificar(T t, String option) throws Exception; 
    
    void eliminar(int id)throws Exception ;
    
    List<T> listarTodos() throws Exception;
    
    T objet(int id) throws Exception; 
    
}