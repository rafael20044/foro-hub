package com.forohub.forohub.domain.usuario.service;

import com.forohub.forohub.domain.usuario.dto.UsuarioBuscar;
import com.forohub.forohub.domain.usuario.dto.UsuarioCreate;
import com.forohub.forohub.domain.usuario.dto.UsuarioRespuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioServicio {

    UsuarioRespuesta create(UsuarioCreate usuarioCreate);

    UsuarioBuscar find(Long id);

    Page<UsuarioBuscar> findAll(Pageable pageable);
}
