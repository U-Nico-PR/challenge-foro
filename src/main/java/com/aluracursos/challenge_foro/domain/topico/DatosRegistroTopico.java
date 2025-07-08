package com.aluracursos.challenge_foro.domain.topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @JsonAlias("autor") @NotNull Long idAutor,
        @JsonAlias("curso") @NotNull Long idCurso
        ) {
}
