package com.nextconsulting.model;

import jakarta.persistence.*;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;
    private String horario;
    private String status;

    @ManyToOne
    private Usuario usuario;
}
