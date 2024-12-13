package com.forohub.forohub.domain.topico.dto;

import com.forohub.forohub.domain.topico.entity.Topico;

import java.time.LocalDate;

public record TopicoRespuesta(

        Long id,

        String titulo,

        String mensaje,

        LocalDate fechaCreacion

) {

    public TopicoRespuesta(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }
}
