package com.example.GestionePrenotazioni;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostazioneService {

	@Autowired
	private PostazioneRepository postazioneRepository;

	public void save(Postazione _postazione) {
		postazioneRepository.save(_postazione);
		log.info("Postazione con ID " + _postazione.getId() + " salvata con successo");

	}

	// - - - - - - - - - - - - - - - METHOD WITH CUSTOM QUERY
	public List<Postazione> cercaPostazione(TipoPostazione _tipoPostazione, String _citta) {
		return postazioneRepository.cercaPostazionePerTipoAndCitta(_tipoPostazione, _citta);

	}

	public boolean postazioneLibera() {
		return false;

	}
}
