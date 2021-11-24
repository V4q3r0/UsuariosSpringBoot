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

    //Método para obtener un usuario indicando su id
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepositorie.findById(id);
    }

    //Método para llamar la función abstracta de buscar usuarios por prioridad
    public ArrayList<UsuarioModel> obtenerPorPrioridad(int prioridad){
        return usuarioRepositorie.findByPrioridad(prioridad);
    }

    //Método para llamar la función abstracta de la interface y buscar usuario por su nombre
    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre){
        return usuarioRepositorie.findByNombre(nombre);
    }

    //Método para llamar la función abstracta de la interface y buscar usuario por email
    public ArrayList<UsuarioModel> obtenerPorEmail(String email){
        return usuarioRepositorie.findByEmail(email);
    }

    //Método para crear un usuario - también funciona para actualizar (si se agrega su id).
    public UsuarioModel crearUsuario(UsuarioModel usuario){
        return usuarioRepositorie.save(usuario);
    }

    //Método para eliminar un usuario por id
    public String eliminarPorId(Long id){
        try{
            usuarioRepositorie.deleteById(id);
            return "Se ha eliminado al usuario de id: "+id;
        }catch(Exception e){
            return "No se ha podido eliminar al usuario de id: "+id;
        }
    }

}
