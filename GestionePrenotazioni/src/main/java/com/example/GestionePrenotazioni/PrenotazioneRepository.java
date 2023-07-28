package com.example.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	// - - - - - - - - - - - - - - - CUSTOM QUERY
	@Query("SELECT p FROM Prenotazione p " + "WHERE p.utente = :utente "
			+ "AND ((p.inizioPrenotazione >= :dataInizio AND p.inizioPrenotazione <= :dataFine) "
			+ "OR (p.finePrenotazione >= :dataInizio AND p.finePrenotazione <= :dataFine) "
			+ "OR (p.inizioPrenotazione <= :dataInizio AND p.finePrenotazione >= :dataFine))")
	List<Prenotazione> cercaPerUtenteAndData(@Param("utente") Utente utente, @Param("dataInizio") LocalDate dataInizio,
			@Param("dataFine") LocalDate dataFine);

	// - - - - - - - - - - - - - - - CUSTOM QUERY
	@Query("SELECT p FROM Prenotazione p " + "WHERE p.postazione = :postazione "
			+ "AND ((p.inizioPrenotazione >= :dataInizio AND p.inizioPrenotazione <= :dataFine) "
			+ "OR (p.finePrenotazione >= :dataInizio AND p.finePrenotazione <= :dataFine) "
			+ "OR (p.inizioPrenotazione <= :dataInizio AND p.finePrenotazione >= :dataFine))")
	List<Prenotazione> cercaPerPostazioneAndData(@Param("postazione") Postazione postazione,
			@Param("dataInizio") LocalDate dataInizio, @Param("dataFine") LocalDate dataFine);

}
