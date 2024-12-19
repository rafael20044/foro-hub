package com.forohub.forohub.domain.usuario.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UsuarioVerificar(
        @NotNull
        @NotEmpty
        String nombre,
        @NotNull
        @NotEmpty
        String clave
) {
}
