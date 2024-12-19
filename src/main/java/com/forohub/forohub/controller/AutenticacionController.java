package com.forohub.forohub.controller;

import com.forohub.forohub.domain.usuario.dto.UsuarioVerificar;
import com.forohub.forohub.domain.usuario.entity.Usuario;
import com.forohub.forohub.infra.security.TokenDTO;
import com.forohub.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDTO> autenticarUsuario(@RequestBody @Valid UsuarioVerificar verificar){
        Authentication authToken = new UsernamePasswordAuthenticationToken(verificar.nombre(), verificar.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        String JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(JWTtoken));
    }
}
