package com.domenico.dto;

import com.domenico.entities.Carta;
import com.domenico.entities.Persona;

public class AssociazioneCartaDTO {
	private Persona persona;
    private Carta carta;

    // Getter e Setter
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }
}
