package com.forohub.forohub.domain.topico.dto;

import com.forohub.forohub.domain.estado.Estado;
import com.forohub.forohub.domain.topico.entity.Topico;
import com.forohub.forohub.domain.usuario.dto.UsuarioBuscar;

import java.time.LocalDate;

public record TopicoBuscar(

        Long id,

        String titulo,

        String mensaje,

        LocalDate fechaCreacion,

        Estado estado,

        UsuarioBuscar idAutor
) {
        public TopicoBuscar(Topico topico){
                this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),topico.getEstado(),
                        new UsuarioBuscar(topico.getIdAutor()));
        }
}
