package com.example.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class PrenotazioniRunner implements CommandLineRunner {

	@Autowired
	private PrenotazioneService prenotazioneService;

	@Override
	public void run(String... args) throws Exception {
		log.info("Runner is running...");

		configWithAnnotationConfig();

	}

	public void configWithAnnotationConfig() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				GestionePrenotazioniApplication.class);

		// - - - - - - - - - - - - - - - SALVATAGGIO OGGETTI SUL DATABASE
		log.info("");
		log.info("* * * * * * * * * * SALVATAGGIO UTENTI, EDIFICI, POSTAZIONI * * * * * * * * * *");
		UtenteService utenteService = ctx.getBean(UtenteService.class);
		Utente primoUtente = ctx.getBean("PrimoUtente", Utente.class);
//		utenteService.save(primoUtente);
		Utente secondoUtente = ctx.getBean("SecondoUtente", Utente.class);
//		utenteService.save(secondoUtente);
		Utente terzoUtente = ctx.getBean("TerzoUtente", Utente.class);
//		utenteService.save(terzoUtente);

		EdificioService edificioService = ctx.getBean(EdificioService.class);
		Edificio primoEdificio = ctx.getBean("PrimoEdificio", Edificio.class);
//		edificioService.save(primoEdificio);
		Edificio secondoEdificio = ctx.getBean("SecondoEdificio", Edificio.class);
//		edificioService.save(secondoEdificio);
		Edificio terzoEdificio = ctx.getBean("TerzoEdificio", Edificio.class);
//		edificioService.save(terzoEdificio);

		PostazioneService postazioneService = ctx.getBean(PostazioneService.class);
		Postazione primaPostazioneMilano = ctx.getBean("PrimaPostazioneMilano", Postazione.class);
//		postazioneService.save(primaPostazioneMilano);
		Postazione secondaPostazioneMilano = ctx.getBean("SecondaPostazioneMilano", Postazione.class);
//		postazioneService.save(secondaPostazioneMilano);
		Postazione primaPostazioneRoma = ctx.getBean("PrimaPostazioneRoma", Postazione.class);
//		postazioneService.save(primaPostazioneRoma);
		Postazione secondaPostazioneRoma = ctx.getBean("SecondaPostazioneRoma", Postazione.class);
//		postazioneService.save(secondaPostazioneRoma);
		Postazione primaPostazioneNapoli = ctx.getBean("PrimaPostazioneNapoli", Postazione.class);
//		postazioneService.save(primaPostazioneNapoli);
		Postazione secondaPostazioneNapoli = ctx.getBean("SecondaPostazioneNapoli", Postazione.class);
//		postazioneService.save(secondaPostazioneNapoli);

		// - - - - - - - - - - - - - - - RICERCA POSTAZIONE
		log.info("");
		log.info("* * * * * * * * * * RICERCA POSTAZIONE * * * * * * * * * *");
		TipoPostazione tipoPostazione = TipoPostazione.PRIVATO;
		String citta = "Napoli";
		List<Postazione> postazioniTrovate = postazioneService.cercaPostazione(tipoPostazione, citta);

		log.info("Postazioni trovate per tipo " + tipoPostazione + " e città " + citta + ":");
		for (Postazione postazione : postazioniTrovate) {
			log.info("Postazione ID: " + postazione.getId());
		}

		// - - - - - - - - - - - - - - - ESECUZIONE PRENOTAZIONE
		log.info("");
		log.info("* * * * * * * * * * ESECUZIONE PRENOTAZIONE * * * * * * * * * *");

		prenotazioneService.effettuaPrenotazione(utenteService.findById(303), LocalDate.of(2023, 7, 28),
				postazioneService.findById(303));

	}

}
