package com.forohub.forohub.domain.usuario.service;

import com.forohub.forohub.domain.usuario.dto.UsuarioBuscar;
import com.forohub.forohub.domain.usuario.dto.UsuarioCreate;
import com.forohub.forohub.domain.usuario.dto.UsuarioRespuesta;
import com.forohub.forohub.domain.usuario.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioServicio {

    UsuarioRespuesta create(UsuarioCreate usuarioCreate);

    UsuarioBuscar find(Long id);

    Usuario findEntity(Long id);

    Page<UsuarioBuscar> findAll(Pageable pageable);

    UserDetails findByNombre(String nombre);
}
