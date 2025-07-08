package com.aluracursos.challenge_foro.domain.topico;

import com.aluracursos.challenge_foro.domain.ValidarException;
import com.aluracursos.challenge_foro.domain.curso.ICursoRepository;
import com.aluracursos.challenge_foro.domain.usuario.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrarTopic {

    @Autowired
    private ITopicoRepository topicoRepository;

    @Autowired
    private ICursoRepository cursoRepository;

    @Autowired
    private IAutorRepository autorRepository;

    public DatosDetalleTopico registrar(DatosRegistroTopico datos){
        if(!cursoRepository.existsById(datos.idCurso())){
            throw new ValidarException("Curso no registrado aún.");
        }
        if(!autorRepository.existsById(datos.idAutor())){
            throw new ValidarException("Usuario no reconocido");
        }
        var usuario = autorRepository.getReferenceById(datos.idAutor());
        var curso = cursoRepository.getReferenceById(datos.idCurso());
        var topico = new Topico(null, datos.titulo(), datos.mensaje(), LocalDateTime.now(), "Consulta", usuario, curso);
        topicoRepository.save(topico);

        return new DatosDetalleTopico(topico);
    }
}
