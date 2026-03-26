package com.nextconsulting;

import com.nextconsulting.model.Agendamento;
import com.nextconsulting.repository.AgendamentoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class NextconsultingApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextconsultingApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(AgendamentoRepository repository) {
		return args -> {
			Agendamento agendamento = new Agendamento();

			agendamento.setData("2026-03-26");
			agendamento.setHorario("10:00");
			agendamento.setStatus("PENDENTE");

			repository.save(agendamento);
		};
	}
}