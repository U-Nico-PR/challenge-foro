package com.aluracursos.challenge_foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTitulo(@NotBlank String titulo);

    boolean existsByMensaje(@NotBlank String mensaje);
}
