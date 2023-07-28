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

	public void save(Postazione postazione) {
		postazioneRepository.save(postazione);
		log.info("Postazione con ID " + postazione.getId() + " salvata con successo");

	}

	// - - - - - - - - - - - - - - - METHOD WITH CUSTOM QUERY
	public List<Postazione> cercaPostazione(TipoPostazione tipoPostazione, String citta) {
		return postazioneRepository.cercaPostazionePerTipoAndCitta(tipoPostazione, citta);

	}

	public boolean postazioneLibera() {
		return postazioneRepository.verificaPostazioneLibera(null, null, null);

	}
}
