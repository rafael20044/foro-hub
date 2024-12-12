package com.forohub.forohub.domain.usuario.dto;

import com.forohub.forohub.domain.usuario.entity.Usuario;

public record UsuarioBuscar(
        Long id,
        String nombre
) {
    public UsuarioBuscar(Usuario usuario){
        this(usuario.getId(), usuario.getNombre());
    }
}
