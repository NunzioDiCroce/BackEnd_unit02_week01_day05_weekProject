package com.example.GestionePrenotazioni;

import java.util.List;
import java.util.Optional;

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

	public Optional<Postazione> findById(long _id) {
		return postazioneRepository.findById(_id);
	}

	// - - - - - - - - - - - - - - - METODO CON CUSTOM QUERY
	public List<Postazione> cercaPostazione(TipoPostazione tipoPostazione, String citta) {
		return postazioneRepository.cercaPostazionePerTipoAndCitta(tipoPostazione, citta);

	}

}
