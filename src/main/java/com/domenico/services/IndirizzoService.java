package com.domenico.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.domenico.dto.IndirizzoDTO;
import com.domenico.dto.PersonaDTO;
import com.domenico.entities.Indirizzo;
import com.domenico.models.IndirizzoMapper;
import com.domenico.models.PersonaMapper;
import com.domenico.repositories.IndirizzoRepository;

@Service
public class IndirizzoService {
	
	private IndirizzoRepository indirizzoRepository;
	
	public IndirizzoService(IndirizzoRepository indirizzoRepository) {
		this.indirizzoRepository = indirizzoRepository;
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

}
