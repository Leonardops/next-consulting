package com.nextconsulting.service;

import com.nextconsulting.model.Agendamento;
import com.nextconsulting.model.StatusAgendamento;
import com.nextconsulting.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public Agendamento salvar(Agendamento agendamento) {
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

        agendamento.setStatus(novoStatus);

        return repository.save(agendamento);
    }
}