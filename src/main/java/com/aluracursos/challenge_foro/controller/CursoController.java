package com.aluracursos.challenge_foro.controller;

import com.aluracursos.challenge_foro.domain.curso.Curso;
import com.aluracursos.challenge_foro.domain.curso.DatosRegistroCurso;
import com.aluracursos.challenge_foro.domain.curso.ICursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private ICursoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroCurso datos){
        repository.save(new Curso(datos));
    }
}
