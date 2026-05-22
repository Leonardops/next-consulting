package com.nextconsulting.controller;

import com.nextconsulting.model.Disponibilidade;
import com.nextconsulting.service.DisponibilidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilidades")
public class DisponibilidadeController {

    private final DisponibilidadeService disponibilidadeService;

    public DisponibilidadeController(DisponibilidadeService disponibilidadeService){
        this.disponibilidadeService = disponibilidadeService;
    }

    @PostMapping
    public Disponibilidade criar(@RequestBody Disponibilidade disponibilidade){
        return disponibilidadeService.salvar(disponibilidade);
    }

    @GetMapping
    public List<Disponibilidade> Listar(){
        return disponibilidadeService.listarTodas();
    }

}
