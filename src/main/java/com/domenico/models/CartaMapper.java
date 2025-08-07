package com.domenico.models;

import java.util.Set;
import java.util.stream.Collectors;

import com.domenico.dto.CartaDTO;
import com.domenico.dto.PersonaDTO;
import com.domenico.entities.Carta;
import com.domenico.entities.Persona;

public class CartaMapper {
	public static Set<CartaDTO> toDTOSet(Set<Carta> carte) {
		if (carte == null) {
			return null; // Handle null case
		}
//		Set<PersonaDTO>persone = carte.stream()
//				.flatMap(carta -> carta.getPersone().stream())
//				.map(PersonaMapper::toDTO)
//				.collect(Collectors.toSet());
//		return carte.stream()
//				.map(carta -> new CartaDTO(carta.getId(), carta.getNumeroCarta(),persone)) // Set persone to null for now
//				.collect(Collectors.toSet());
		return carte.stream()
				.map(carta -> new CartaDTO(carta.getId(), carta.getNumeroCarta(), null)) // Set persone to null for now
				.collect(Collectors.toSet());
	}

	
	
}
