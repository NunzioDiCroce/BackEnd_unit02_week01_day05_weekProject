package com.example.GestionePrenotazioni;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration

@PropertySource("classpath:application.properties")

public class BeansConfiguration {

	@Bean(name = "PrimoEdificio")
	public Edificio getPrimoEdificio() {
		return new Edificio("Primo Edificio", "Primo Indirizzo", "Milano");
	}

	@Bean(name = "PrimaPostazione")
	public Postazione getPrimaPostazione() {
		return new Postazione("Prima Postazione", TipoPostazione.PRIVATO, 1, getPrimoEdificio());
	}

	@Bean(name = "PrimoUtente")
	public Utente getPrimoUtente() {
		return new Utente("primoUtente", "Mario Rossi", "marioRossi@mail.com");
	}

}
