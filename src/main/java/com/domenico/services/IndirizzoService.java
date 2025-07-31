package com.domenico.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domenico.entities.Indirizzo;
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

}
