package com.ssjeison.ForoHubAlura.service;

import com.ssjeison.ForoHubAlura.model.Topico;
import com.ssjeison.ForoHubAlura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> obtenerTodos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> obtenerPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico crearTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico actualizarTopico(Long id, Topico nuevoTopico) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(nuevoTopico.getTitulo());
            topico.setMensaje(nuevoTopico.getMensaje());
            topico.setStatus(nuevoTopico.getStatus());
            topico.setAutor(nuevoTopico.getAutor());
            topico.setCurso(nuevoTopico.getCurso());
            return topicoRepository.save(topico);
        }).orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}
