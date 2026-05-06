package com.nextconsulting.repository;

import com.nextconsulting.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    @Query("SELECT COUNT(a) > 0 FROM Agendamento a WHERE a.data = :data AND a.horario = :horario")
    boolean existeAgendamento(@Param("data") String data, @Param("horario") String horario);
}

