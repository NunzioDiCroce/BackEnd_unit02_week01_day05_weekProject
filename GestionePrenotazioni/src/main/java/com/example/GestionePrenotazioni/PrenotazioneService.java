package com.example.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.List;

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
		log.info("Prenotazione con ID " + _prenotazione.getId() + " salvata con successo");

	}

	// - - - - - - - - - - - - - - - METODO CON CUSTOM QUERY
	public boolean prenotazionePossibile(Utente utente, Postazione postazione, LocalDate dataInizio,
			LocalDate dataFine) {
		List<Prenotazione> prenotazioniUtente = prenotazioneRepository.cercaPerUtenteAndData(utente, dataInizio,
				dataFine);
		if (!prenotazioniUtente.isEmpty()) {
			return false; // L'UTENTE HA GIA UNA PRENOTAZIONE IN QUELLE DATE
		}

		List<Prenotazione> prenotazioniPostazione = prenotazioneRepository.cercaPerPostazioneAndData(postazione,
				dataInizio, dataFine);
		return prenotazioniPostazione.isEmpty(); // LA POSTAZIONE E' LIBERA IN QUELLE DATE
	}
}
