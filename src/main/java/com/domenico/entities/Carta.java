package com.domenico.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Carta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String numeroCarta;
	@JsonBackReference // Utilizzato per evitare la serializzazione circolare tra Carta e Persona
	@ManyToMany(mappedBy = "carte") // mappedBy indica che la relazione è gestita dalla classe Persona
	//@JoinTable(name = "persona_carta", joinColumns = @JoinColumn(name = "carta_id"), 
	//		   inverseJoinColumns = @JoinColumn(name = "persona_id")) 
	Set<Persona>persone;// Associazioni con la classe Persona possono essere aggiunte se necessario
	
	public Carta() {
		// Default constructor for JPA
	}
	public Carta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public Carta(String numeroCarta, Set<Persona> persone) {
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
	public Set<Persona> getPersone() {
		return persone;
	}
	public void aggiungiPersona(Persona persona) {
		persone.add(persona);
		persona.getCarte().add(this); // Assicurati che la relazione sia bidirezionale
		
	}
	public void setPersone(Set<Persona> persone) {
		this.persone = persone;
	}
	
	public String toString() {
		return "Carte [id=" + id + ", numeroCarta=" + numeroCarta + "]";
	}
	
	

}
