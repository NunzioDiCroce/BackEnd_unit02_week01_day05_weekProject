package com.example.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class Prenotazione {

	@Id
	@GeneratedValue
	private long id;

	protected LocalDate inizioPrenotazione;
	protected LocalDate finePrenotazione;

	@ManyToMany
	protected Set<Utente> utenti;

	@ManyToMany
	protected Set<Postazione> postazioni;

}
