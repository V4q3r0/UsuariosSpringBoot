package com.usuario.demo.repositories;

import java.util.ArrayList;

import com.usuario.demo.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Indicamos que es un Repository, además que es una interfaz y va extenderse a CrudRepository (para usar sus metodos).
@Repository
public interface UsuarioRepositorie extends CrudRepository<UsuarioModel, Long>{
    
    //Funcion abstracta para buscar usuario por prioridad
    public abstract ArrayList<UsuarioModel> findByPrioridad(int prioridad);

}
