package com.example.GestionePrenotazioni;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration

@PropertySource("classpath:application.properties")

public class BeansConfiguration {

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private PostazioneService postazioneService;
	@Autowired
	private PrenotazioneService prenotazioneService;

	@Bean(name = "PrimoEdificio")
	public Edificio getPrimoEdificio() {
		return new Edificio("Primo Edificio", "Primo Indirizzo", "Milano");
	}

	@Bean(name = "SecondoEdificio")
	public Edificio getSecondoEdificio() {
		return new Edificio("Secondo Edificio", "Secondo Indirizzo", "Roma");
	}

	@Bean(name = "TerzoEdificio")
	public Edificio getTerzoEdificio() {
		return new Edificio("Terzo Edificio", "Terzo Indirizzo", "Napoli");
	}

	@Bean(name = "PrimaPostazioneMilano")
	public Postazione getPrimaPostazioneMilano() {
		return new Postazione("Prima Postazione Milano", TipoPostazione.PRIVATO, 1, getPrimoEdificio());
	}

	@Bean(name = "SecondaPostazioneMilano")
	public Postazione getSecondaPostazioneMilano() {
		return new Postazione("Seconda Postazione Milano", TipoPostazione.PRIVATO, 1, getPrimoEdificio());
	}

	@Bean(name = "PrimaPostazioneRoma")
	public Postazione getPrimaPostazioneRoma() {
		return new Postazione("Prima Postazione Roma", TipoPostazione.PRIVATO, 1, getSecondoEdificio());
	}

	@Bean(name = "SecondaPostazioneRoma")
	public Postazione getSecondaPostazioneRoma() {
		return new Postazione("Seconda Postazione Roma", TipoPostazione.PRIVATO, 1, getSecondoEdificio());
	}

	@Bean(name = "PrimaPostazioneNapoli")
	public Postazione getPrimaPostazioneNapoli() {
		return new Postazione("Prima Postazione Napoli", TipoPostazione.PRIVATO, 1, getTerzoEdificio());
	}

	@Bean(name = "SecondaPostazioneNapoli")
	public Postazione getSecondaPostazioneNapoli() {
		return new Postazione("Seconda Postazione Napoli", TipoPostazione.PRIVATO, 1, getTerzoEdificio());
	}

	@Bean(name = "PrimoUtente")
	public Utente getPrimoUtente() {
		return new Utente("primoUtente", "Mario Rossi", "MarioRossi@mail.com");
	}

	@Bean(name = "SecondoUtente")
	public Utente getSecondoUtente() {
		return new Utente("secondoUtente", "Paolo Bianchi", "PaoloBianchi@mail.com");
	}

	@Bean(name = "TerzoUtente")
	public Utente getTerzoUtente() {
		return new Utente("terzotente", "Claudio Neri", "ClaudioNeri@mail.com");
	}

	@Bean(name = "PrimaPrenotazione")
	public Prenotazione getPrimaPrenotazione() {
		return new Prenotazione(utenteService.findById(0), LocalDate.of(2023, 7, 15), postazioneService.findById(0));
	}

}
