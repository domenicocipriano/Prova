package com.domenico.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domenico.entities.Carta;
import com.domenico.entities.Persona;
import com.domenico.repositories.CartaRepository;
import com.domenico.repositories.CategoriaRepository;
import com.domenico.repositories.PersonaRepository;

@Service
public class AssociazioneCartaService {

    private final CategoriaRepository categoriaRepository;
	
	@Autowired
	private CartaRepository cartaRepository;
	@Autowired
	private PersonaRepository personaRepository;
	
	
	public AssociazioneCartaService(CartaRepository cartaRepository, PersonaRepository personaRepository, CategoriaRepository categoriaRepository) {
		this.cartaRepository = cartaRepository;
		this.personaRepository = personaRepository;
		this.categoriaRepository = categoriaRepository;
	}

	public void associaCartaPersonaNew2(Long personaId, Long cartaId) {
	    Optional<Carta> cartaOpt = cartaRepository.findById(cartaId);
	    Optional<Persona> personaOpt = personaRepository.findById(personaId);

	    if (cartaOpt.isPresent() && personaOpt.isPresent()) {
	        Carta carta = cartaOpt.get();
	        Persona persona = personaOpt.get();

	        // Aggiunge la carta alla lista delle carte della persona (senza sovrascrivere)
	        persona.getCarte().add(carta);
	        // Aggiunge la persona alla lista delle persone della carta
	        carta.getPersone().add(persona);

	        // Salva solo uno dei due se la relazione è gestita correttamente da entrambi i lati
	        personaRepository.save(persona); // o cartaRepository.save(carta)
	    } else {
	        throw new RuntimeException("Carta o Persona non trovata con gli ID forniti: Carta ID = " + cartaId + ", Persona ID = " + personaId);
	    }
	}
	
	
	
//	public void associaCartaPersona(Long cartaId,Long personaId) {
//		Optional<Carta>carta = cartaRepository.findById(cartaId);
//		System.out.println("Carta trovata: " + carta);
//		Optional<Persona> persona = personaRepository.findById(personaId);
//		System.out.println("Persona trovata: " + persona);
//		if(carta.isPresent() && persona.isPresent()) {
//			Carta cartaTrovata = carta.get();
//			System.out.println(cartaTrovata);
//			Persona personaTrovata = persona.get();
//			System.out.println(personaTrovata);
//			cartaTrovata.aggiungiPersona(personaTrovata);
//			cartaRepository.save(cartaTrovata);
//			personaTrovata.aggiungiCarta(cartaTrovata);
//			personaRepository.save(personaTrovata);
			
//			Carta cartaTrovata = carta.get();
//			Persona personaTrovata = persona.get();
//			Set<Carta> listaCarte = new HashSet<>();
//			listaCarte.add(cartaTrovata);
//			Set<Persona>listaPersone = new HashSet<>();
//			listaPersone.add(personaTrovata);
//			personaTrovata.setCarte(listaCarte);
//			cartaTrovata.setPersone(listaPersone);
//			cartaRepository.save(cartaTrovata);
//			personaRepository.save(personaTrovata);
//		} else {
//			throw new RuntimeException("Carta o Persona non trovata con gli ID forniti: Carta ID = " + cartaId + ", Persona ID = " + personaId);
//		}
//	}
	
	
	

}
