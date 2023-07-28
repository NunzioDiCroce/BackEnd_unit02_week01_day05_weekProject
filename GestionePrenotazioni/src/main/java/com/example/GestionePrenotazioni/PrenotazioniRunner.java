package com.example.GestionePrenotazioni;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class PrenotazioniRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		log.info("Runner is running...");

		configWithAnnotationConfig();

	}

	public static void configWithAnnotationConfig() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				GestionePrenotazioniApplication.class);

		EdificioService edificioService = ctx.getBean(EdificioService.class);
		PostazioneService postazioneService = ctx.getBean(PostazioneService.class);
		UtenteService utenteService = ctx.getBean(UtenteService.class);

		log.info("");
		log.info("* * * * * * * * * * SAVE * * * * * * * * * *");
		Edificio primoEdificio = ctx.getBean("PrimoEdificio", Edificio.class);
		edificioService.save(primoEdificio);

		Postazione primaPostazione = ctx.getBean("PrimaPostazione", Postazione.class);
		postazioneService.save(primaPostazione);

		Utente primoUtente = ctx.getBean("PrimoUtente", Utente.class);
		utenteService.save(primoUtente);

	}

}
