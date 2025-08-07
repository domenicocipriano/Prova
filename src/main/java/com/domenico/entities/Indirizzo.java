package com.domenico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String via;
	private String citta;
	private String cap;
	private String provincia;
	
	@OneToOne(mappedBy = "indirizzo") // mappedBy indica che la relazione è gestita dalla classe Persona
	private Persona persona;
	
	public Indirizzo() {
	}
	public Persona getPersona() {
		return persona;
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
