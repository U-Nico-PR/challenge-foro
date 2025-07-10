package com.aluracursos.challenge_foro.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {
}
