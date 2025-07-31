package com.domenico.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Carta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String numeroCarta;
	
	@ManyToMany(mappedBy = "carte") // mappedBy indica che la relazione è gestita dalla classe Persona
	//@JoinTable(name = "persona_carta", joinColumns = @JoinColumn(name = "carta_id"), 
	//		   inverseJoinColumns = @JoinColumn(name = "persona_id")) 
	List<Persona>persone;// Associazioni con la classe Persona possono essere aggiunte se necessario
	
	public Carta() {
		// Default constructor for JPA
	}
	public Carta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public Carta(String numeroCarta, List<Persona> persone) {
		this(numeroCarta);
		this.persone = persone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
//	public Set<Persona> getPersone() {
//		return persone;
//	}
	public void aggiungiPersona(Persona persona) {
		persone.add(persona);
		persona.getCarte().add(this); // Assicurati che la relazione sia bidirezionale
		
	}
	public void setPersone(List<Persona> persone) {
		this.persone = persone;
	}
	
	public String toString() {
		return "Carte [id=" + id + ", numeroCarta=" + numeroCarta + "]";
	}
	
	

}
