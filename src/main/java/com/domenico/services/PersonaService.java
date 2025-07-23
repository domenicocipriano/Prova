package com.domenico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domenico.entities.Persona;
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
	public List getAll() {
		return personaRepository.findAll();
	}
	public Persona getPersonaById(Long id) {
		return personaRepository.findById(id).orElse(null);

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

}
