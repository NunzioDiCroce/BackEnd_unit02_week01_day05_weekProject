package com.example.GestionePrenotazioni;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "prenotazioni")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j

@Builder

public class Prenotazione {

	@Id
	@GeneratedValue
	private long id;

	protected LocalDate dataPrenotazione;

	@ManyToOne
	protected Utente utente;

	@ManyToOne
	protected Postazione postazione;

	public Prenotazione(LocalDate _dataPrenotazione, Utente _utente, Postazione _postazione) {
		this.dataPrenotazione = _dataPrenotazione;
		this.utente = _utente;
		this.postazione = _postazione;
	}

}
