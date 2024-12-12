package com.forohub.forohub.domain.usuario.service;

import com.forohub.forohub.domain.usuario.dto.UsuarioCreate;
import com.forohub.forohub.domain.usuario.entity.Usuario;
import com.forohub.forohub.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioServicio{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void create(UsuarioCreate usuarioCreate) {
        Usuario usuario = new Usuario(usuarioCreate);
        repository.save(usuario);
    }
}
