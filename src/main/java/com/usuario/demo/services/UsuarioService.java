package com.usuario.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.usuario.demo.models.UsuarioModel;
import com.usuario.demo.repositories.UsuarioRepositorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Anotación para indicar que es un Servicio
@Service
public class UsuarioService {
    
    //Anotación para no instanciar la variable del objeto.
    @Autowired
    UsuarioRepositorie usuarioRepositorie;

    //Método para obtener todos los usuarios
    public ArrayList<UsuarioModel> obtenerUsuarios(){

        return (ArrayList<UsuarioModel>) usuarioRepositorie.findAll();

    }

    //Método para crear un usuario - también funciona para actualizar (si se agrega su id).
    public UsuarioModel crearUsuario(UsuarioModel usuario){

        return usuarioRepositorie.save(usuario);

    }

    //Método para obtener un usuario indicando su id
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepositorie.findById(id);
    }

    //Método para llamar la función abstracta de buscar usuarios por prioridad
    public ArrayList<UsuarioModel> obtenerPorPrioridad(int prioridad){
        return usuarioRepositorie.findByPrioridad(prioridad);
    }

    //Método para eliminar un usuario por id
    public boolean eliminarPorId(Long id){
        try{
            usuarioRepositorie.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
