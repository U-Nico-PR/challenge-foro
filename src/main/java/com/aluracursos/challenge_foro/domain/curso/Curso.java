package com.aluracursos.challenge_foro.domain.curso;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Curso {

    private String nombre_curso;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosCurso curso) {
        this.nombre_curso = curso.nombre();
        this.categoria = curso.categoria();
    }

    public void actualizar(DatosCurso curso) {
        if(curso.nombre() != null){
            this.nombre_curso = curso.nombre();
        }
        if(curso.categoria() != null){
            this.categoria = curso.categoria();
        }
    }
}
