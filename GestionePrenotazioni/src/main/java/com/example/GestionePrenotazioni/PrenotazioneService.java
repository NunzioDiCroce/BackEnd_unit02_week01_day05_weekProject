package com.example.GestionePrenotazioni;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	public void save(Prenotazione _prenotazione) {
		prenotazioneRepository.save(_prenotazione);
		log.info("Prenotazione con ID " + _prenotazione.getId() + " salvata con successo.");

	}

// - - - - - - - - - - - - - - - METODO CON CUSTOM QUERY
	public void effettuaPrenotazione(Utente utente, LocalDate dataPrenotazione, Postazione postazione) {

		Prenotazione prenotazionePostazione = prenotazioneRepository
				.findByDataPrenotazioneAndPostazione(dataPrenotazione, postazione);

		Prenotazione prenotazioneUtente = prenotazioneRepository.findByDataPrenotazioneAndUtente(dataPrenotazione,
				utente);

		if (prenotazionePostazione != null) {
			log.warn(
					"Non è possibile salvare la prenotazione, esiste già una prenotazione per la data e la postazione desiderata.");
		} else if (prenotazioneUtente != null) {
			log.warn(
					"Non è possibile salvare la prenotazione, l'utente ha già una prenotazione per la data desiderata.");
		} else {
			Prenotazione prenotazione = new Prenotazione(utente, dataPrenotazione, postazione);
			prenotazioneRepository.save(prenotazione);
			log.info("Prenotazione con ID " + prenotazione.getId() + " salvata con successo.");
		}

	}

}