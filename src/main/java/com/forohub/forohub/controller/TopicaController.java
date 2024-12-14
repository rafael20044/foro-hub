package com.forohub.forohub.controller;


import com.forohub.forohub.domain.topico.dto.TopicoBuscar;
import com.forohub.forohub.domain.topico.dto.TopicoCrear;
import com.forohub.forohub.domain.topico.dto.TopicoEditar;
import com.forohub.forohub.domain.topico.dto.TopicoRespuesta;
import com.forohub.forohub.domain.topico.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topico")
public class TopicaController {

    @Autowired
    private TopicoService service;

    @PostMapping
    private ResponseEntity<TopicoRespuesta> create(@RequestBody @Validated TopicoCrear crear, UriComponentsBuilder builder){
        TopicoRespuesta respuesta = service.createTopico(crear);
        URI uri = builder.path("/topico/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @GetMapping("/{id}")
    private ResponseEntity<TopicoBuscar> find(@PathVariable Long id){
        TopicoBuscar buscar = service.findTopico(id);
        return ResponseEntity.ok(buscar);
    }

    @GetMapping
    private ResponseEntity<Page<TopicoBuscar>> findAll(Pageable pageable){
        Page<TopicoBuscar> page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    private ResponseEntity<TopicoRespuesta> edit(@RequestBody @Validated TopicoEditar editar){
        TopicoRespuesta respuesta = service.editar(editar);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
