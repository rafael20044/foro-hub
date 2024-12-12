package com.forohub.forohub.domain.topico.entity;

import com.forohub.forohub.domain.estado.Estado;
import com.forohub.forohub.domain.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "topico")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String titulo;

    @Column(nullable = true)
    private String mensaje;

    @Column(nullable = true)
    private LocalDate fechaCreacion;

    @Column(nullable = true)
    private Estado estado;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Usuario idAutor;
}
