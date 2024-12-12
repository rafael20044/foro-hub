package com.forohub.forohub.domain.usuario.entity;

import com.forohub.forohub.domain.usuario.dto.UsuarioCreate;
import jakarta.persistence.*;

@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String correo;


    @Column(length = 500, nullable = true)
    private String clave;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String correo, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    public Usuario(UsuarioCreate usuarioCreate){
        this.nombre = usuarioCreate.nombre();
        this.correo = usuarioCreate.correo();
        this.clave = usuarioCreate.clave();
    }

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
