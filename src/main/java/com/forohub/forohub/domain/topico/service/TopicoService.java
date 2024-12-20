package com.forohub.forohub.domain.topico.service;

import com.forohub.forohub.domain.topico.dto.TopicoBuscar;
import com.forohub.forohub.domain.topico.dto.TopicoCrear;
import com.forohub.forohub.domain.topico.dto.TopicoEditar;
import com.forohub.forohub.domain.topico.dto.TopicoRespuesta;
import com.forohub.forohub.domain.topico.entity.Topico;
import com.forohub.forohub.domain.topico.repository.TopicoRepository;
import com.forohub.forohub.domain.usuario.entity.Usuario;
import com.forohub.forohub.domain.usuario.repository.UsuarioRepository;
import com.forohub.forohub.infra.exception.FindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService implements ITopicoServicio{

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public TopicoBuscar findTopico(Long id) {
        Optional<Topico> optional = repository.findById(id);
        if (optional.isPresent()) {
            Topico topico = optional.get();
            return new TopicoBuscar(topico);
        }
        throw new FindException("Topico no encontrado");
    }

    @Override
    public TopicoRespuesta createTopico(TopicoCrear crear) {
        Usuario usuario = usuarioRepository.findById(crear.idAutor().id()).
                orElseThrow(() -> new FindException("No encontrado el susuario"));
        Topico topico = new Topico(crear, usuario);
        repository.save(topico);
        return new TopicoRespuesta(topico);
    }

    @Override
    public Page<TopicoBuscar> findAll(Pageable pageable) {
        return repository.pageAll(pageable).map(TopicoBuscar::new);
    }

    @Override
    public TopicoRespuesta editar(TopicoEditar editar) {
        Optional<Topico> optional = repository.findById(editar.id());
        if (optional.isPresent()) {
            Topico topico = optional.get();
            topico.actualizar(editar);
            repository.save(topico);
            return new TopicoRespuesta(topico);
        }
        throw new FindException("El topico que desea editar no existe");
    }

    @Override
    public void delete(Long id) {
        Optional<Topico> optional = repository.findById(id);
        if (optional.isPresent()) {
            Topico topico = optional.get();
            topico.eliminar();
            repository.save(topico);
        }
        throw new FindException("El topico que desea eliminar no existe");
    }
}
