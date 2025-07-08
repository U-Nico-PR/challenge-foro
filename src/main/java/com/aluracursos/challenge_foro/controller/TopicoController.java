package com.aluracursos.challenge_foro.controller;

import com.aluracursos.challenge_foro.domain.topico.DatosRegistroTopico;
import com.aluracursos.challenge_foro.domain.topico.ITopicoRepository;
import com.aluracursos.challenge_foro.domain.topico.RegistrarTopic;
import com.aluracursos.challenge_foro.domain.topico.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistrarTopic registrar;

    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos){
        var datosTopico = registrar.registrar(datos);
        System.out.println(datosTopico);
    }
}
