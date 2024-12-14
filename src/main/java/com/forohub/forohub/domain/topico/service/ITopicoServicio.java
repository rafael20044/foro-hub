package com.forohub.forohub.domain.topico.service;

import com.forohub.forohub.domain.topico.dto.TopicoBuscar;
import com.forohub.forohub.domain.topico.dto.TopicoCrear;
import com.forohub.forohub.domain.topico.dto.TopicoEditar;
import com.forohub.forohub.domain.topico.dto.TopicoRespuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITopicoServicio {

    TopicoBuscar findTopico(Long id);

    TopicoRespuesta createTopico(TopicoCrear crear);

    Page<TopicoBuscar> findAll(Pageable pageable);

    TopicoRespuesta editar(TopicoEditar editar);

    void delete(Long id);
}
