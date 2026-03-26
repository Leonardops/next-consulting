package com.nextconsulting.contorller;

import com.nextconsulting.model.Agendamento;
import com.nextconsulting.repository.AgendamentoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoRepository repository;

    public AgendamentoController(AgendamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Agendamento> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
        return repository.save(agendamento);
    }
}
