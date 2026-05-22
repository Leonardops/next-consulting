package com.nextconsulting.service;

import com.nextconsulting.model.Disponibilidade;
import com.nextconsulting.repository.DisponibilidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadeService {

    private final DisponibilidadeRepository disponibilidadeRepository;

    public DisponibilidadeService(DisponibilidadeRepository disponibilidadeRepository) {
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    public Disponibilidade salvar(Disponibilidade disponibilidade) {
        return disponibilidadeRepository.save(disponibilidade);
    }

    public List<Disponibilidade> listarTodas() {
        return disponibilidadeRepository.findAll();
    }
}
