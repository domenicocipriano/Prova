package com.domenico.dto;

import java.util.Set;

public class PersonaDTO {
	private Long id;
    private String nome;
    private String cognome;
    private IndirizzoDTO indirizzo;
    private UserDTO user;
    private Set<CartaDTO> carte;

    public PersonaDTO(Long id, String nome, String cognome,IndirizzoDTO indirizzo, UserDTO user, Set<CartaDTO> carte) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.user = user;
        this.carte = carte;
    }

    public IndirizzoDTO getIndirizzo() {
		return indirizzo;
	}
    public Set<CartaDTO> getCarte() {
		return carte;
	}
    public void setCarte(Set<CartaDTO> carte) {
		this.carte = carte;
	}

	public void setIndirizzo(IndirizzoDTO indirizzo) {
		this.indirizzo = indirizzo;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	// Getter e Setter
    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) {
    	this.id = id; 
    }
    public String getNome() {
    	return nome;
    }
    public void setNome(String nome) {
    	this.nome = nome; 
    }
    public String getCognome() { 
    	return cognome; 
    }
    public void setCognome(String cognome) {
    	this.cognome = cognome; 
    }
}
