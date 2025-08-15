package com.domenico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domenico.dto.IndirizzoDTO;
import com.domenico.entities.Indirizzo;
import com.domenico.entities.Persona;
import com.domenico.models.IndirizzoMapper;
import com.domenico.repositories.IndirizzoRepository;
import com.domenico.repositories.PersonaRepository;

@Service
public class IndirizzoService {
	
	private IndirizzoRepository indirizzoRepository;
	
	private PersonaRepository personaRepository; // Aggiunto per gestire le associazioni con Persona
	
	public IndirizzoService(IndirizzoRepository indirizzoRepository,
			PersonaRepository personaRepository) {
		this.indirizzoRepository = indirizzoRepository;
		this.personaRepository = personaRepository;
		
	}
	
	public Indirizzo creaIndirizzo(Indirizzo indirizzo) {
		return indirizzoRepository.save(indirizzo);
	}
	public List<Indirizzo> getAllIndirizzi() {
		return indirizzoRepository.findAll();
	}
	public List<IndirizzoDTO> getAllIndirizzoDTO() {
		return indirizzoRepository.findAll().stream()
			.map(IndirizzoMapper::toDTO).collect(Collectors.toList());
	
		
	}
//	public Indirizzo updateIndirizzo(Long id, Indirizzo indirizzo) {
//		Optional<Persona> personaOptional = personaRepository.findById(id);
//		Persona personaTrovata = personaOptional.get();
//		Indirizzo indirizzoEsistente = personaTrovata.getIndirizzo();
//		indirizzoEsistente.setVia(indirizzo.getVia());
//		indirizzoEsistente.setCitta(indirizzo.getCitta());
//		indirizzoEsistente.setCap(indirizzo.getCap());
//		indirizzoEsistente.setProvincia(indirizzo.getProvincia());
//		System.out.println("Indirizzo esistente: " + indirizzoEsistente);
//		return indirizzoRepository.save(indirizzoEsistente);
//		
//	}

}
