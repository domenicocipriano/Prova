package com.domenico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domenico.dto.PersonaDTO;
import com.domenico.entities.Persona;
import com.domenico.models.PersonaMapper;
import com.domenico.repositories.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	public void creaPersona(Persona persona) {
		personaRepository.save(persona);
		
	}
	public Persona creaPersona2(Persona persona) {
		return personaRepository.save(persona);
	}
	public void creaPersona(String nome, String cognome) {
		Persona persona = new Persona();
		persona.setNome(nome);
		persona.setCognome(cognome);
		personaRepository.save(persona);
	}
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}
	public Optional<Persona> getPersonaById(Long id) {
		return personaRepository.findById(id);

	}
	public void deletePersona(Long id) {
		personaRepository.deleteById(id);
	}
	public List<Persona>cercaPerNome(String nome){
		return personaRepository.findByNome(nome);
	}
	public List<Persona>cercaPerCognome(String cognome){
		return personaRepository.findByCognome(cognome);
	}
	
	public Persona update(Persona persona) {
		Long id = persona.getId();
		Optional<Persona> personaTrovata = personaRepository.findById(id);
		if (personaTrovata.isPresent()){
			Persona personaDaAggiornare = personaTrovata.get();
			personaDaAggiornare.setNome(persona.getNome());
			personaDaAggiornare.setCognome(persona.getCognome());
			return personaRepository.save(personaDaAggiornare);
		} else {
			throw new RuntimeException("Persona non trovata con ID: " + id);
			
		}
		
	}
	public List<PersonaDTO> getAllPersonaDTO() {
		return personaRepository.findAll().stream()
				.map(PersonaMapper::toDTO).collect(Collectors.toList()); // Mappa le entità Persona a DTO
		//converte le entità Persona in DTO utilizzando il mapper
		//Raccoglie tutti i PersonaDTO generati in una nuova lista (List<PersonaDTO>) e la restituisce
		
			
		
	}

}
