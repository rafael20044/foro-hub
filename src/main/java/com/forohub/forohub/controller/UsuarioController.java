package com.forohub.forohub.controller;

import com.forohub.forohub.domain.usuario.dto.UsuarioBuscar;
import com.forohub.forohub.domain.usuario.dto.UsuarioCreate;
import com.forohub.forohub.domain.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    private ResponseEntity createUsuario(@RequestBody @Validated UsuarioCreate usuarioCreate){
        service.create(usuarioCreate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<UsuarioBuscar> findUsuario(@PathVariable Long id){
        UsuarioBuscar buscar = service.find(id);
        return ResponseEntity.ok(buscar);
    }
}
