package com.forohub.forohub.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UsuarioCreate(

        @NotNull
        @NotEmpty
        String nombre,

        @NotNull
        @NotEmpty
        @Email
        String correo,

        @NotNull
        @NotEmpty
        String clave
) {
}
