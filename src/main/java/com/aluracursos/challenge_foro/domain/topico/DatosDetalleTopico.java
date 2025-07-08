package com.aluracursos.challenge_foro.domain.topico;

import com.aluracursos.challenge_foro.domain.curso.Categoria;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        String estatus,
        LocalDateTime fecha
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getFecha()
        );
    }
}
