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
		Edificio secondoEdificio = ctx.getBean("SecondoEdificio", Edificio.class);
		edificioService.save(secondoEdificio);
		Edificio terzoEdificio = ctx.getBean("TerzoEdificio", Edificio.class);
		edificioService.save(terzoEdificio);

		Postazione primaPostazioneMilano = ctx.getBean("PrimaPostazioneMilano", Postazione.class);
		postazioneService.save(primaPostazioneMilano);
		Postazione secondaPostazioneMilano = ctx.getBean("SecondaPostazioneMilano", Postazione.class);
		postazioneService.save(secondaPostazioneMilano);
		Postazione primaPostazioneRoma = ctx.getBean("PrimaPostazioneRoma", Postazione.class);
		postazioneService.save(primaPostazioneRoma);
		Postazione secondaPostazioneRoma = ctx.getBean("SecondaPostazioneRoma", Postazione.class);
		postazioneService.save(secondaPostazioneRoma);
		Postazione primaPostazioneNapoli = ctx.getBean("PrimaPostazioneNapoli", Postazione.class);
		postazioneService.save(primaPostazioneNapoli);
		Postazione secondaPostazioneNapoli = ctx.getBean("SecondaPostazioneNapoli", Postazione.class);
		postazioneService.save(secondaPostazioneNapoli);

		Utente primoUtente = ctx.getBean("PrimoUtente", Utente.class);
		utenteService.save(primoUtente);
		Utente secondoUtente = ctx.getBean("SecondoUtente", Utente.class);
		utenteService.save(secondoUtente);
		Utente terzoUtente = ctx.getBean("TerzoUtente", Utente.class);
		utenteService.save(terzoUtente);

	}

}
