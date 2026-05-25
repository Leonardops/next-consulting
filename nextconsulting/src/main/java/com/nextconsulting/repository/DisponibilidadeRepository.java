package com.nextconsulting.repository;

import com.nextconsulting.model.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisponibilidadeRepository  extends JpaRepository<Disponibilidade, Long> {

    boolean existsByDataAndHorario(String data, String horario);
}
