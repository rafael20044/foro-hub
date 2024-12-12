package com.forohub.forohub.domain.usuario.service;

import com.forohub.forohub.domain.usuario.dto.UsuarioBuscar;
import com.forohub.forohub.domain.usuario.dto.UsuarioCreate;
import com.forohub.forohub.domain.usuario.entity.Usuario;
import com.forohub.forohub.domain.usuario.repository.UsuarioRepository;
import com.forohub.forohub.infra.exception.FindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioServicio{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void create(UsuarioCreate usuarioCreate) {
        Usuario usuario = new Usuario(usuarioCreate);
        repository.save(usuario);
    }

    public UsuarioBuscar find(Long id){
        Optional<Usuario> optional = repository.findById(id);
        if (optional.isPresent()) {
            return new UsuarioBuscar(optional.get());
        }
        throw new FindException("Usuario no encontrado");
    }
}
