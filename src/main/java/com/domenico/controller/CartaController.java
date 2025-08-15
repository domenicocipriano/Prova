package com.domenico.controller;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domenico.dto.CartaDTO;
import com.domenico.entities.Carta;
import com.domenico.services.CartaService;

@RestController
public class CartaController {
	
	Logger LOGGER = Logger.getLogger(CartaController.class.getName());
	
	@Autowired
	private CartaService cartaService;
	
	@PostMapping("/api/carta")
	public ResponseEntity<Carta> aggiungiCarta(@RequestBody Carta carta) {
		Carta cartaAggiunta = cartaService.aggiungiCarta(carta);
		LOGGER.info("Carta aggiunta: " + cartaAggiunta);
		URI location = URI.create("/api/carta/" + cartaAggiunta.getId());
		if (cartaAggiunta != null) {
			return ResponseEntity.status(HttpStatus.CREATED).header("location",location.toString()).body(cartaAggiunta);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	@GetMapping("/api/carte")
	public Set<CartaDTO> getAllCarte() {
		return cartaService.getAllCarte();
	}

}
