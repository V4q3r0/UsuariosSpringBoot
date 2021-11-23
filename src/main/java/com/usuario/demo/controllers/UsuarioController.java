package com.usuario.demo.controllers;

import java.util.ArrayList;

import com.usuario.demo.models.UsuarioModel;
import com.usuario.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        
        return usuarioService.obtenerUsuarios();

    }

    @PostMapping
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.crearUsuario(usuario);
    }

}
