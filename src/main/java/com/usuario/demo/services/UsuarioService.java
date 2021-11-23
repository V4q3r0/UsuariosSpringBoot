package com.usuario.demo.services;

import java.util.ArrayList;

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



}
