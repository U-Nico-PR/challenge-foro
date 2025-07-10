package com.aluracursos.challenge_foro.controller;


import com.aluracursos.challenge_foro.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ITopicoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        repository.save(new Topico(datos));
    }

    @GetMapping
    public Page<DatosListaTopicos> listar(@PageableDefault(size = 10, sort = {"fecha"}, direction = Sort.Direction.ASC) Pageable paginacion){
        return repository.findAll(paginacion).map(DatosListaTopicos::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosListaTopicos(topico));
    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        Optional<Topico> topicoBuscado = repository.findById(id);
        if(topicoBuscado.isPresent()){
            var topico = topicoBuscado.get();
            topico.actualizarTopic(datos);
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        Optional<Topico> topicoAEliminar = repository.findById(id);
        if(topicoAEliminar.isPresent()){
            repository.deleteById(id);
        }
    }
}
