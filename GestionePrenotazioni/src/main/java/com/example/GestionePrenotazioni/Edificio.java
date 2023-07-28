package com.example.GestionePrenotazioni;

import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Edificio {

	@Id
	@GeneratedValue
	private long id;

	protected String nome;
	protected String indirizzo;
	protected String citta;

	@OneToMany
	protected Set<Postazione> postazioni;

}
