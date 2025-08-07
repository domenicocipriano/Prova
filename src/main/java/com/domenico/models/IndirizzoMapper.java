package com.domenico.models;

import com.domenico.dto.IndirizzoDTO;
import com.domenico.dto.PersonaDTOLight;
import com.domenico.entities.Indirizzo;
import com.domenico.entities.Persona;

public class IndirizzoMapper {
	public static IndirizzoDTO toDTO(Indirizzo indirizzo) {
		Persona persona = indirizzo.getPersona();
		System.out.println(persona);
        PersonaDTOLight personaDTOLight = null;
        if (persona != null) {
            personaDTOLight = new PersonaDTOLight(persona.getId(), persona.getNome(), persona.getCognome());
            System.out.println("PersonaDTO Light: " + personaDTOLight.getCognome());
            
        }

        return new IndirizzoDTO(indirizzo.getId(),indirizzo.getVia(),indirizzo.getCitta(),indirizzo.getCap(),indirizzo.getProvincia(),personaDTOLight);
        
    }
}
