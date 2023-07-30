package com.example.GestionePrenotazioni;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	// - - - - - - - - - - - - - - - CUSTOM QUERY
	Prenotazione findByDataPrenotazioneAndPostazione(LocalDate dataPrenotazione, Postazione postazione);

	// - - - - - - - - - - - - - - - CUSTOM QUERY
	Prenotazione findByDataPrenotazioneAndUtente(LocalDate dataPrenotazione, Utente utente);

}
