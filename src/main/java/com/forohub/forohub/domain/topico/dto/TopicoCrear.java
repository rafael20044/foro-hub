package com.forohub.forohub.domain.topico.dto;

import com.forohub.forohub.domain.estado.Estado;
import com.forohub.forohub.domain.usuario.dto.UsuarioBuscar;
import com.forohub.forohub.domain.usuario.dto.UsuarioCreate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TopicoCrear(

        @NotNull
        @NotEmpty
        String titulo,

        @NotNull
        @NotEmpty
        String mensaje,

        @NotNull
        LocalDate fechaCreacion,

        @NotNull
        Estado estado,

        @NotNull
        UsuarioBuscar idAutor
) {
}
