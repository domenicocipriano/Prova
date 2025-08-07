package com.domenico.models;

import java.util.Set;

import com.domenico.dto.CartaDTO;
import com.domenico.dto.IndirizzoDTO;
import com.domenico.dto.PersonaDTO;
import com.domenico.dto.UserDTO;
import com.domenico.entities.Persona;

public class PersonaMapper {
	public static PersonaDTO toDTO(Persona persona) {
		if (persona == null) {
			return null; // Handle null case
		}
		UserDTO userDTO = UserMapper.toDTO(persona.getUser());
		Set<CartaDTO> carteDTO = CartaMapper.toDTOSet(persona.getCarte());
		IndirizzoDTO indirizzoDTO = IndirizzoMapper.toDTO(persona.getIndirizzo());
		return new PersonaDTO(persona.getId(), persona.getNome(), persona.getCognome(),indirizzoDTO, userDTO,carteDTO);
		
	}
}
