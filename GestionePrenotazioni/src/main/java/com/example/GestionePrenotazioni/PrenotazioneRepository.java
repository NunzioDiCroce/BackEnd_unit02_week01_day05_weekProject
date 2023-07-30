package com.example.GestionePrenotazioni;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	Prenotazione findByDataPrenotazioneAndPostazione(LocalDate dataPrenotazione, Postazione postazione);

}
