package com.nextconsulting.service;

import com.nextconsulting.model.Agendamento;
import com.nextconsulting.model.StatusAgendamento;
import com.nextconsulting.repository.AgendamentoRepository;
import com.nextconsulting.repository.DisponibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository, DisponibilidadeRepository disponibilidadeRepository) {
        this.repository = repository;
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    private final DisponibilidadeRepository disponibilidadeRepository;


    public Agendamento salvar(Agendamento agendamento) {

        boolean disponibilidadeExiste =
                disponibilidadeRepository.existsByDataAndHorario(
                        agendamento.getData(),
                        agendamento.getHorario()
                );

        if (!disponibilidadeExiste) {
            throw new IllegalArgumentException(
                    "Horário não disponível para agendamento."
            );
        }

        if (repository.existeAgendamento(agendamento.getData(), agendamento.getHorario())) {
            throw new IllegalArgumentException("Já existe um agendamento para essa data e horário!");
        }

        return repository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    public Agendamento atualizarStatus(Long id, StatusAgendamento novoStatus) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        if (agendamento.getStatus() == novoStatus) {
            throw new RuntimeException("O agendamento já possui esse  status");
        }

        if (agendamento.getStatus() == StatusAgendamento.APROVADO) {
            throw new RuntimeException("Um agendamento aprovado não pode ser alterado");
        }

        if (agendamento.getStatus() == StatusAgendamento.REJEITADO) {
            throw new RuntimeException("Um agendamento rejeitado não pode ser alterado");
        }

        agendamento.setStatus(novoStatus);

        return repository.save(agendamento);
    }
}