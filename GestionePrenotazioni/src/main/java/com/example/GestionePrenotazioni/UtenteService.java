package com.example.GestionePrenotazioni;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;

	public void save(Utente _utente) {
		utenteRepository.save(_utente);
		log.info("Utente con ID " + _utente.getId() + " salvato con successo");

	}

	public Optional<Utente> findById(long _id) {
		return utenteRepository.findById(_id);

	}

}
