package com.domenico.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domenico.entities.Ordine;
import com.domenico.services.OrdineService;

@RestController
public class OrdineController {
	
	Logger LOGGER = Logger.getLogger(OrdineController.class.getName());
	
	private OrdineService ordineService;
	
	public OrdineController(OrdineService ordineService) {
		this.ordineService = ordineService;
	}
	
	@PostMapping("/api/ordine/{userId}")
	public Ordine creaOrdine(@PathVariable Long userId,@RequestParam String nomeProdotto,@RequestParam Double prezzo) {
		return ordineService.creaOrdine(userId, nomeProdotto, prezzo);
	}
	@GetMapping("/api/ordine/{userId}")
	public List<Ordine> getAllOrdiniByUserId(@PathVariable Long userId) {
		List<Ordine> ordini = ordineService.getAllOrdiniByUserId(userId);
		if(ordini.isEmpty()) {
			LOGGER.info("No orders found for user with ID: " + userId);
		} else {
			LOGGER.info("Found " + ordini.size() + " orders for user with ID: " + userId);
			for (Ordine ordine : ordini) {
				LOGGER.info("Order details: " + ordine);
			}
		}
		return ordineService.getAllOrdiniByUserId(userId);
	}

}
