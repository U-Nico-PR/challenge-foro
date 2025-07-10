package com.aluracursos.challenge_foro.domain.topico;

import com.aluracursos.challenge_foro.domain.curso.DatosCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String autor,
        @NotNull @Valid DatosCurso curso
) {
}
