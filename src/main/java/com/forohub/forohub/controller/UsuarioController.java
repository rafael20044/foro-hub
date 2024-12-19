package com.forohub.forohub.controller;

import com.forohub.forohub.domain.usuario.dto.UsuarioBuscar;
import com.forohub.forohub.domain.usuario.dto.UsuarioCreate;
import com.forohub.forohub.domain.usuario.dto.UsuarioRespuesta;
import com.forohub.forohub.domain.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    private ResponseEntity<UsuarioRespuesta> createUsuario(@RequestBody @Valid UsuarioCreate usuarioCreate,
                                                           UriComponentsBuilder builder){
        UsuarioRespuesta respuesta = service.create(usuarioCreate);
        URI uri = builder.path("/usuario/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UsuarioBuscar> findUsuario(@PathVariable Long id){
        UsuarioBuscar buscar = service.find(id);
        return ResponseEntity.ok(buscar);
    }

    @GetMapping
    private ResponseEntity<Page<UsuarioBuscar>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }
}
