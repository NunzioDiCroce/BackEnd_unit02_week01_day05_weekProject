package com.example.GestionePrenotazioni;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Postazione {

	@Id
	@GeneratedValue
	private long id;

	protected String descrizione;
	protected TipoPostazione tipoPostazione;
	protected int numeroMassimoOccupanti;

	@ManyToOne
	private Edificio edificio;

}
