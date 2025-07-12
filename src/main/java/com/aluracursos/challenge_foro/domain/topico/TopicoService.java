package com.aluracursos.challenge_foro.domain.topico;

import com.aluracursos.challenge_foro.domain.ValidarException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private ITopicoRepository repository;

    @Transactional
    public Topico registrar(DatosRegistroTopico datos) {
        boolean existeTitulo = repository.existsByTitulo(datos.titulo());
        boolean existeMensaje = repository.existsByMensaje(datos.mensaje());

        if(existeTitulo && existeMensaje){
            throw new ValidarException("Ya existe un registro con titulo y mensaje iguales.");
        } else if(existeMensaje) {
            throw new ValidarException("Ya existe un registro con el mismo mensaje.");
        } else if(existeTitulo) {
            throw new ValidarException("Ya existe un registro con el mismo titulo.");
        }

        var topico = new Topico(datos);
        repository.save(topico);
        return topico;
    }

    public Page listar(Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosDetalleTopico::new);
    }

    public Topico detallar(Long id) {
        var existeTopico = repository.findById(id);
        if(existeTopico.isPresent()) {
            return repository.getReferenceById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public Topico actualizar(Long id, DatosActualizarTopico datos) {
        var existeTopico = repository.findById(id);
        if(existeTopico.isPresent()){
            var topico = existeTopico.get();
            topico.actualizarTopic(datos);
            return topico;
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public void eliminar(Long id) {
        Optional<Topico> topicoAEliminar = repository.findById(id);
        if(topicoAEliminar.isPresent()){
            repository.deleteById(id);
        }
    }
}
