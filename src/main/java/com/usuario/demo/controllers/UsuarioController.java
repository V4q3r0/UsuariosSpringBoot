package com.usuario.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.usuario.demo.models.UsuarioModel;
import com.usuario.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") int prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuarioPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarPorId(id);
        if(ok){
            return "Se ha eliminado el usuario de id: "+id;
        }else{
            return "No se ha podido eliminar el usuario de id: "+id;
        }
    }

}
