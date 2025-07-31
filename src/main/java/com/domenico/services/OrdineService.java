package com.domenico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domenico.entities.Ordine;
import com.domenico.entities.User;
import com.domenico.repositories.OrdineRepository;
import com.domenico.repositories.UserRepository;

@Service
public class OrdineService {
	
	private OrdineRepository ordineRepository;
	@Autowired
	private UserRepository userRepository;
	
	public OrdineService(OrdineRepository ordineRepository) {
		this.ordineRepository = ordineRepository;
		this.userRepository = userRepository;
	}
	public Ordine creaOrdine(Long userId, String nomeProdotto, Double prezzo) {
		Optional<User>user = userRepository.findById(userId);
		System.out.println(user);
		if(user.isPresent()) {
			Ordine ordine = new Ordine(nomeProdotto, prezzo, user.get());
			return ordineRepository.save(ordine);
		}else {
			throw new RuntimeException("Utente non trovato: " + userId);
		}
		
		
	}
	public List<Ordine> getAllOrdini() {
		return ordineRepository.findAll();
	}
	public List<Ordine>getAllOrdiniByUserId(Long userId){
		return ordineRepository.findAll().stream()
				.filter(ordine -> ordine.getUser().getId().equals(userId))
				.toList();
	}

}
