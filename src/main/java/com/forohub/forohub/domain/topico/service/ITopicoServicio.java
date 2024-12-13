package com.forohub.forohub.domain.topico.service;

import com.forohub.forohub.domain.topico.dto.TopicoBuscar;
import com.forohub.forohub.domain.topico.dto.TopicoCrear;
import com.forohub.forohub.domain.topico.dto.TopicoRespuesta;

public interface ITopicoServicio {

    TopicoBuscar findTopico(Long id);

    TopicoRespuesta createTopico(TopicoCrear crear);

}
