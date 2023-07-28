package com.example.GestionePrenotazioni;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "postazioni")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j

@Builder

public class Postazione {

	@Id
	@GeneratedValue
	private long id;

	protected String descrizione;

	@Enumerated(EnumType.STRING)
	protected TipoPostazione tipoPostazione;

	protected int numeroMassimoOccupanti;

	@ManyToOne
	private Edificio edificio;

}
