package com.forohub.forohub.domain.topico.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TopicoEditar(

        @NotNull
        Long id,

        String titulo,

        String mensaje

) {
}
