package com.aluracursos.challenge_foro.domain.topico;

import com.aluracursos.challenge_foro.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private String autor;
    private String status;
    @Embedded
    private Curso curso;

    public Topico(DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha = LocalDateTime.now();
        this.autor = datos.autor();
        this.status = "Sin respuesta";
        this.curso = new Curso(datos.curso());
    }

    public void actualizarTopic(DatosActualizarTopico datos) {
        if(datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if(datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if(datos.autor() != null){
            this.autor = datos.autor();
        }
        if(datos.curso() != null){
            this.curso.actualizar(datos.curso());
        }
        this.fecha = LocalDateTime.now();
    }
}
