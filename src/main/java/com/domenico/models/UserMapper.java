package com.domenico.models;

import com.domenico.dto.PersonaDTOLight;
import com.domenico.dto.UserDTO;
import com.domenico.entities.Persona;
import com.domenico.entities.User;

public class UserMapper {
	public static UserDTO toDTO(User user) {
		if (user == null) {
			return null; // Handle null case
		}
		Persona persona = user.getPersona();
		PersonaDTOLight personaDTOLight = null;
		if (persona != null) {
			personaDTOLight = new PersonaDTOLight(persona.getId(), persona.getNome(), persona.getCognome());
			System.out.println("PersonaDTO Light: " + personaDTOLight.getCognome());
		} else {
			System.out.println("Persona is null in UserMapper");
		}

        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), personaDTOLight);
    }
}
