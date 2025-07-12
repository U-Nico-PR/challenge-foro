package com.aluracursos.challenge_foro.domain.topico;

import com.aluracursos.challenge_foro.domain.curso.Curso;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String estado,
        String autor,
        Curso curso
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
