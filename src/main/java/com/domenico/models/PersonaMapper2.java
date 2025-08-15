package com.domenico.models;

import java.util.Set;

import com.domenico.dto.CartaDTO;
import com.domenico.dto.IndirizzoDTO;
import com.domenico.dto.PersonaDTO;
import com.domenico.dto.UserDTO;
import com.domenico.entities.Persona;

public class PersonaMapper2 {
	public static PersonaDTO toDTO(Set<Persona> persone) {
		if (persone == null) {
			return null; // Handle null case
		}
		UserDTO userDTO = UserMapper.toDTO(persone.iterator().next().getUser());
		Set<CartaDTO> carteDTO = CartaMapper.toDTOSet(persone.iterator().next().getCarte());
		IndirizzoDTO indirizzoDTO = IndirizzoMapper.toDTO(persone.iterator().next().getIndirizzo());
		return new PersonaDTO(
			persone.iterator().next().getId(),
			persone.iterator().next().getNome(),
			persone.iterator().next().getCognome(),
			indirizzoDTO,
			userDTO,
			carteDTO
		);
		
	}
}
