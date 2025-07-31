package com.domenico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domenico.entities.Carta;
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

	
	
	
}
