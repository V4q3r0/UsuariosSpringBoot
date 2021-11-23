package com.usuario.demo.models;

import javax.persistence.*;

//Indicamos el nombre de la tabla
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    //Parametros con sus anotación para que Spring conozca que se va realizar, diciendo que es una ID, que se va incrementar, etc.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String email;
    private int prioridad;

    //Métodos Getter and Setters.
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    
    
}
