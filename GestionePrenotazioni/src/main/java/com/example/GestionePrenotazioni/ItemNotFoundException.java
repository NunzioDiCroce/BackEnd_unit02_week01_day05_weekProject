package com.example.GestionePrenotazioni;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(long _id) {
		super("Item with id " + _id + " not found!");
	}

}
