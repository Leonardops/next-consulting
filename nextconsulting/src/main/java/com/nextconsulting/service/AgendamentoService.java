package com.nextconsulting.service;

import com.nextconsulting.model.Agendamento;
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
}