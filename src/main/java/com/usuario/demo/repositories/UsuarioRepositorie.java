package com.usuario.demo.repositories;

import com.usuario.demo.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorie extends CrudRepository<UsuarioModel, Long>{
    


}
