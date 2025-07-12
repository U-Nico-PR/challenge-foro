package com.aluracursos.challenge_foro.controller;

import com.aluracursos.challenge_foro.domain.usuario.DatosAutenticacion;
import com.aluracursos.challenge_foro.domain.usuario.Usuario;
import com.aluracursos.challenge_foro.infra.security.DatosTokenJWT;
import com.aluracursos.challenge_foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.password());
        var autenticacion = manager.authenticate(authenticationToken);
        var usuario = (Usuario) autenticacion.getPrincipal();
        var tokenJWT = tokenService.generarToken(usuario);
        return ResponseEntity.ok(new DatosTokenJWT(usuario.getNombre(), tokenJWT));
    }
}
