package com.forohub.forohub.domain.usuario.entity;

import com.forohub.forohub.domain.usuario.dto.UsuarioCreate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuario")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String correo;


    @Column(length = 500, nullable = true)
    private String clave;

    public Usuario(UsuarioCreate usuarioCreate){
        this.nombre = usuarioCreate.nombre();
        this.correo = usuarioCreate.correo();
        this.clave = usuarioCreate.clave();
    }
}
