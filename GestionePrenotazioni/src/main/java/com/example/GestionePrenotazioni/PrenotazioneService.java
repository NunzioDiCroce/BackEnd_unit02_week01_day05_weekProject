package com.example.GestionePrenotazioni;

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

}
