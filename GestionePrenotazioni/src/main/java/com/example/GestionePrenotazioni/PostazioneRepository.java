package com.example.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	// - - - - - - - - - - - - - - - CUSTOM QUERY
	@Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipoPostazione AND p.edificio.citta = :citta")
	List<Postazione> cercaPostazionePerTipoAndCitta(@Param("tipoPostazione") TipoPostazione tipoPostazione,
			@Param("citta") String citta);

	// - - - - - - - - - - - - - - - CUSTOM QUERY
	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " + "FROM Prenotazione pr " + "JOIN pr.postazione p "
			+ "WHERE p.id = :postazioneId " + "AND pr.inizioPrenotazione <= :dataFine "
			+ "AND pr.finePrenotazione >= :dataInizio")
	boolean postazioneLibera(@Param("postazioneId") Long postazioneId, @Param("dataInizio") LocalDate dataInizio,
			@Param("dataFine") LocalDate dataFine);

}
