package com.nextconsulting.controller;

import com.nextconsulting.model.Agendamento;
import com.nextconsulting.repository.AgendamentoRepository;
import org.springframework.web.bind.annotation.*;
import com.nextconsulting.service.AgendamentoService;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;}


    @GetMapping
    public List<Agendamento> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
            return service.salvar(agendamento);
    }
}
