package com.domenico.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domenico.dto.PersonaDTO;
import com.domenico.entities.Carta;
import com.domenico.models.CartaMapper;
import com.domenico.models.PersonaMapper;
import com.domenico.repositories.CartaRepository;

@Service
public class CartaService {
	
	@Autowired
	private CartaRepository cartaRepository;
	
	public CartaService(CartaRepository cartaRepository) {
		this.cartaRepository = cartaRepository;
	}
	public Carta aggiungiCarta(Carta carta) {
		return cartaRepository.save(carta);
	}
	public List<Carta> getAllCarte() {
		return cartaRepository.findAll();
	}
//	public Set<CartaDTO>getCarteDTO(){
//		Set<CartaDTO> carte = cartaRepository.findAll();
//		return carte.stream()
//				.map(carta -> new CartaDTO(carta.getId(), carta.getNumeroCarta())) // Set persone to null for now
//				.collect(Collectors.toSet());
//	}
	
		
	
	
	
	
	
}
