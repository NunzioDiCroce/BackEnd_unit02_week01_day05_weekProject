package com.example.GestionePrenotazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRepository;

	public void save(Edificio _edificio) {
		edificioRepository.save(_edificio);
		log.info("Edificio con ID " + _edificio.getId() + " salvato con successo");

	}

}
