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

        boolean horarioExiste =
                disponibilidadeRepository.existsByDataAndHorario(
                        disponibilidade.getData(),
                        disponibilidade.getHorario()
                );

        if (horarioExiste){
            throw new RuntimeException("Horário indisponível.");
        }

        disponibilidade.setDisponivel(true);

        return disponibilidadeRepository.save(disponibilidade);
    }

    public List<Disponibilidade> listarTodas() {
        return disponibilidadeRepository.findAll();
    }
}
