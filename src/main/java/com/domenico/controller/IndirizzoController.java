package com.domenico.controller;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domenico.dto.IndirizzoDTO;
import com.domenico.entities.Indirizzo;
import com.domenico.services.IndirizzoService;

@RestController
public class IndirizzoController {
	
	Logger LOGGER = Logger.getLogger(IndirizzoController.class.getName());
	
	private IndirizzoService indirizzoService;
	
	public IndirizzoController(IndirizzoService indirizzoService) {
		this.indirizzoService = indirizzoService;
		// Constructor logic if needed
	}
	
	@PostMapping("/api/indirizzo")
	public ResponseEntity<String> createIndirizzo(@RequestBody Indirizzo indirizzo) {
		if(indirizzo.getVia() == "" || indirizzo.getCitta() == "" || indirizzo.getCap() == "") {
			LOGGER.warning("Via, Citta or Cap is null for indirizzo: " + indirizzo);
			indirizzo.setVia(null);
			indirizzo.setCitta(null);
			indirizzo.setCap(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Via, Citta and Cap must not be null");
		}
		LOGGER.info("Starting creation of indirizzo: " + indirizzo);
		indirizzoService.creaIndirizzo(indirizzo);
		LOGGER.info("Created indirizzo: " + indirizzo);
		URI location = URI.create("/api/indirizzo/" + indirizzo.getId());
		return ResponseEntity.status(HttpStatus.CREATED)
				.header("location", location.toString())
				.body("Indirizzo created successfully");
	}
	@GetMapping("/api/indirizzo")
	public ResponseEntity<List<Indirizzo>> getIndirizzi() {
		List<Indirizzo>listaIndirizzi = indirizzoService.getAllIndirizzi();
		LOGGER.info("Retrieved indirizzi: " + listaIndirizzi);
		if (!listaIndirizzi.isEmpty()) {
			return ResponseEntity.ok(indirizzoService.getAllIndirizzi());
		} else {
			LOGGER.warning("Indirizzo not found: ");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@GetMapping("/api/indirizzoDTO")
	public ResponseEntity<List<IndirizzoDTO>> getIndirizziDTO() {
		List<Indirizzo> listaIndirizzi = indirizzoService.getAllIndirizzi();
		LOGGER.info("Retrieved indirizzi DTO: " + listaIndirizzi);
		if (!listaIndirizzi.isEmpty()) {
			return ResponseEntity.ok(indirizzoService.getAllIndirizzoDTO());
		} else {
			LOGGER.warning("Indirizzo DTO not found: ");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
//	@PutMapping("/api/indirizzo/update/{id}")
//	public ResponseEntity<Indirizzo> updateIndirizzo(@PathVariable Long id, @RequestBody Indirizzo indirizzo) {
//		
//		Indirizzo updatedIndirizzo = indirizzoService.updateIndirizzo(id, indirizzo);
//		if (updatedIndirizzo != null) {
//			LOGGER.info("Updated indirizzo: " + updatedIndirizzo);
//			return ResponseEntity.ok(updatedIndirizzo);
//		} else {
//			
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//	}

}
