package com.domenico.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domenico.services.AssociazioneCartaService;

@RestController
public class AssociazioneCartaController {
	
	private AssociazioneCartaService associazioneCartaService;
	
	public AssociazioneCartaController(AssociazioneCartaService associazioneCartaService) {
		this.associazioneCartaService = associazioneCartaService;
	}
//	@PostMapping("/api/associazione/{cartaId}/{personaId}")
//	public String associazione(@PathVariable Long cartaId,@PathVariable Long personaId) {
//		try {
//			associazioneCartaService.associaCartaPersona(cartaId, personaId);
//			return "Carta associata con successo alla persona.";
//		} catch (RuntimeException e) {
//			return "Errore durante l'associazione: " + e.getMessage();
//		} catch (Exception e) {
//			return "Errore sconosciuto: " + e.getMessage();
//		}
//		
//		
//	}
	@PostMapping("/api/associazionenew/{cartaId}/{personaId}")
	public String associazioneNew(@PathVariable Long cartaId,@PathVariable Long personaId) {
		try {
			associazioneCartaService.associaCartaPersonaNew(cartaId, personaId);
			return "Carta associata con successo alla persona.";
		} catch (RuntimeException e) {
			return "Errore durante l'associazione: " + e.getMessage();
		} catch (Exception e) {
			return "Errore sconosciuto: " + e.getMessage();
		}
		
		
	}

}
