package com.forohub.forohub.domain.topico.entity;

import com.forohub.forohub.domain.estado.Estado;
import com.forohub.forohub.domain.topico.dto.TopicoCrear;
import com.forohub.forohub.domain.usuario.entity.Usuario;
import com.forohub.forohub.domain.usuario.repository.UsuarioRepository;
import com.forohub.forohub.domain.usuario.service.UsuarioService;
import com.forohub.forohub.infra.exception.FindException;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;
import java.util.Optional;

@Table(name = "topico")
@Entity
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

    public Topico(){
    }

    public Topico(Long id, String titulo, String mensaje, LocalDate fechaCreacion, Estado estado, Usuario idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.idAutor = idAutor;
    }

    public Topico(TopicoCrear crear, Usuario autor){
        this.titulo = crear.titulo();
        this.mensaje = crear.mensaje();
        this.fechaCreacion = crear.fechaCreacion();
        this.estado = crear.estado();
        this.idAutor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public Usuario getIdAutor() {
        return idAutor;
    }
}
