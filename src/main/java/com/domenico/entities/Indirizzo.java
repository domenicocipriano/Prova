package com.domenico.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Indirizzo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String via;
	private String citta;
	private String cap;
	private String provincia;
	@JsonBackReference // Indica che questa è la parte "non gestita" della relazione, utile per evitare loop infiniti durante la serializzazione JSON
	@OneToOne(mappedBy = "indirizzo") // mappedBy indica che la relazione è gestita dalla classe Persona
	private Persona persona;
	
	public Indirizzo() {
		// Costruttore di default necessario per JPA
	}
	
	public Indirizzo(String via, String citta, String cap, String provincia) {
		this.via = via;
		this.citta = citta;
		this.cap = cap;
		this.provincia = provincia;
	}
	public Indirizzo(String via, String citta, String cap, String provincia, Persona persona) {
		this(via, citta, cap, provincia);
		this.persona = persona;
	}
	public Persona getPersona() {
		return persona;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", via=" + via + ", citta=" + citta + ", cap=" + cap + ", provincia=" + provincia
				+ "]";
	}
	
	
	
	

}
