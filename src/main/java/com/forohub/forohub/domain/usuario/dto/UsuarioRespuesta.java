package com.forohub.forohub.domain.usuario.dto;

import com.forohub.forohub.domain.usuario.entity.Usuario;

public record UsuarioRespuesta(

        Long id,
        String nombre,
        String correo

) {

    public UsuarioRespuesta(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo());
    }
}
