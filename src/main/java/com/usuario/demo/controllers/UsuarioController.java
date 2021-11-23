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

//Indicamos que es un Controlador
@RestController
@RequestMapping("/usuario") //Indicamos la ruta (end point)
public class UsuarioController {
    
    //Anotación para no instanciar el objeto
    @Autowired
    UsuarioService usuarioService;

    //Anotación para indicar que va ser un GET y llamamos el servicio de obtener usuarios.
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    //Anotación para indicar que va ser un POST y llamamos el servicio de crear usuario.
    @PostMapping
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.crearUsuario(usuario);
    }

    //Anotación para indicar que es de tipo GET y vamos a enviar un dato y llamamos el servicio de obtener usuario por id.
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    //Anotación para indicar que va ser un GET y enviaremos un parametro llamamos el servicio de obtener por prioridad.
    @GetMapping(path = "/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") int prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    //Anotación para indicar que va ser un DELETE y llamamos el servicio de eliminar usuario por id.
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
