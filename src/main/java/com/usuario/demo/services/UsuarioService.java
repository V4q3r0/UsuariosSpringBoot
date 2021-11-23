package com.usuario.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.usuario.demo.models.UsuarioModel;
import com.usuario.demo.repositories.UsuarioRepositorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepositorie usuarioRepositorie;

    public ArrayList<UsuarioModel> obtenerUsuarios(){

        return (ArrayList<UsuarioModel>) usuarioRepositorie.findAll();

    }

    public UsuarioModel crearUsuario(UsuarioModel usuario){

        return usuarioRepositorie.save(usuario);

    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepositorie.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(int prioridad){
        return usuarioRepositorie.findByPrioridad(prioridad);
    }

    public boolean eliminarPorId(Long id){
        try{
            usuarioRepositorie.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
