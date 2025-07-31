package com.domenico.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domenico.entities.Persona;
import com.domenico.services.PersonaService;


@RestController
//RestController is a convenience annotation that combines @Controller and @ResponseBody
public class PersonaController {
	
	private PersonaService personaService;
	private static final Logger LOGGER = Logger.getLogger(PersonaController.class.getName());
	
	@Autowired
	PersonaController(PersonaService personaService) {
		// Constructor injection of PersonaService
		this.personaService = personaService;
		
	}
	
	@GetMapping("/createPersona")
	public String createPersona(@RequestParam String nome, @RequestParam String cognome) {
	
		LOGGER.info("Creating persona with nome: " + nome + " and cognome: " + cognome);
		// Logic to create a persona
		personaService.creaPersona(nome, cognome);
		LOGGER.info("Persona created with nome: " + nome + " and cognome: " + cognome);
		return nome+ " " + cognome + " created successfully!";
	}
//	@PostMapping("/api/persona")
//	public Persona createPersona2(@RequestBody Persona persona) {
//		
//		LOGGER.info("starting creation of persona: " + persona);
//		personaService.creaPersona(persona);
//		LOGGER.info("Created persona: " + persona);
//		//return "Persona " + persona.getNome() + " " + persona.getCognome() + " created successfully!";
//		return persona;
//	}
//	@PostMapping(consumes = {"application/json", "application/xml"}, value="/api/persona")
//	public ResponseEntity<String> createPersonaResponseEntity(@RequestBody Persona persona) {
//		LOGGER.info("Starting creation of persona: " + persona);
//		personaService.creaPersona(persona);
//		LOGGER.info("Created persona: " + persona);
//		return ResponseEntity.ok("prodotto creato "+persona);  //accetta un oggetto da restituire come risposta
//	}
	@PostMapping("/api/persona")
	public ResponseEntity<String>createPersona(@RequestBody Persona persona){
		if(persona.getNome() == null || persona.getCognome() == null) {
			LOGGER.warning("Nome or Cognome is null in the request body.");
			return ResponseEntity.badRequest().body("l'ordine deve contenere nome e cognome");
		}
		Persona createdPersona = personaService.creaPersona2(persona);
		LOGGER.info("Created persona: " + createdPersona);
		URI location = URI.create("/api/persona/" + createdPersona.getId());
		//return ResponseEntity.created(location).body(createdPersona.toString());
		return ResponseEntity.status(HttpStatus.CREATED).header("location","/api/persona/" + createdPersona.getId())
				.body("Persona creata con successo!!!");  //.header header personalizzato
		
	}
	
	@GetMapping("/getPersona")
	public Persona getPersona() {
		return new Persona();
	}
//	@GetMapping("/api/persona")
//	public List<Persona>getAll(){
//		List<Persona> lista = personaService.getAll();
//		LOGGER.info("Retrieved all persona: " + lista);
//		return lista;
//	}
	@GetMapping("/api/persona")
	public ResponseEntity<List<Persona>>getAllResponse(){
		List<Persona> lista = personaService.getAll();
		if(lista.isEmpty()) {
			LOGGER.warning("No personas found.");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
		} else {
			LOGGER.info("Retrieved all personas: " + lista);
			return ResponseEntity.ok(lista); // 200 OK with the list of personas
		}
	}
	@PostMapping("/api/persona3")
	public ResponseEntity<Persona>creaPersona3(@RequestBody Persona persona){
		Persona createdPersona = personaService.creaPersona2(persona);
		LOGGER.info("Created persona: " + createdPersona);
		return ResponseEntity.ok(createdPersona); // 200 OK with the created persona
	}
//	@GetMapping("/api/persona")
//	public List<Persona> getAllPersona() {
//		List<Persona> lista = personaService.getAll();
//		return lista;
//	}
//	@GetMapping("/api/persona/{id}")
//	public ResponseEntity<String> getPersonaById(@PathVariable Long id) {
//		LOGGER.info("Retrieving persona with ID: " + id);
//		// Logic to retrieve a persona by ID
//		// Assuming you have a method in PersonaService to get a persona by ID
//		Persona persona = personaService.getPersonaById(id);
//		if(persona == null) {
//			LOGGER.warning("Persona with ID " + id + " not found.");
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					.body("Persona non trovata!"); 
//			
//		}
//		
//		LOGGER.info("Retrieved persona: " + persona);
//		//return ResponseEntity.ok("persona trovata: " + persona.getNome() + " " + persona.getCognome());
//		return ResponseEntity.status(HttpStatus.OK)
//				.body("Persona trovata: " + persona.getNome() + " " + persona.getCognome());
//		
//	}
	@GetMapping("/api/persona2/{id}")
	public Persona getPersonaById2(@PathVariable Long id) {
		LOGGER.info("Retrieving persona with ID: " + id);
		// Logic to retrieve a persona by ID
		// Assuming you have a method in PersonaService to get a persona by ID
		Persona persona = personaService.getPersonaById(id);
		if (persona == null) {
			LOGGER.warning("Persona with ID " + id + " not found.");
			return null; // or throw an exception
		}
		LOGGER.info("Retrieved persona: " + persona);
		return persona;
		
	}
	@DeleteMapping("/api/persona/{id}")
	public String deletePersona(@PathVariable Long id) {
		Persona persona = personaService.getPersonaById(id);
		if (persona == null) {
			LOGGER.warning("Persona with ID " + id + " not found.");
			return "Persona non trovata!";
		}
		LOGGER.info("Deleting persona with ID: " + id);
		personaService.deletePersona(id);
		LOGGER.info("Deleted persona with ID: " + id);
		return "Persona eliminata con successo!";
		
	}
//	@GetMapping("/api/persona2/{id}")
//	public Persona getPersonaById2(@PathVariable Integer id) {
//		return new Persona(id,"cipriano","domenico");
//	}
	
	@GetMapping("/api/pers") // http://localhost:8080/api/pers?nome=Domenico&cognome=Cipriano
	public String getPers(@RequestParam String nome,@RequestParam String cognome) {
		return "Persona: " + nome + " " + cognome;
	}
	@GetMapping("/api/persona/getByNome")
	public ResponseEntity<List<Persona>> getPersonaByNome(@RequestParam String nome) {
		LOGGER.info("Retrieving personas with nome: " + nome);
		List<Persona> persona = personaService.cercaPerNome(nome);
		if (persona.isEmpty()) {
			LOGGER.warning("No personas found with nome: " + nome);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
		}
		LOGGER.info("Retrieved personas: " + persona);
		return ResponseEntity.ok(persona); // 200 OK with the list of personas
	}
	@GetMapping("/api/persona/getByCognome")
	public ResponseEntity<List<Persona>> getPersonaByCognome(@RequestParam String cognome) {
		LOGGER.info("Retrieving personas with cognome: " + cognome);
		List<Persona> persona = personaService.cercaPerCognome(cognome);
		if (persona.isEmpty()) {
			LOGGER.warning("No personas found with cognome: " + cognome);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
		}
		LOGGER.info("Retrieved personas: " + persona);
		return ResponseEntity.ok(persona); // 200 OK with the list of personas
	}
	
	

}
