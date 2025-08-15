package com.domenico.dto;

import java.util.Set;

public class CartaDTO {
	private Long id;
	private String numeroCarta;
	Set<PersonaDTOLight> persone; // Uncomment if needed later
	
	public CartaDTO() {
		// Default constructor
	}
	public CartaDTO(Long id, String numeroCarta, Set<PersonaDTOLight> persone) {
		this.id = id;
		this.numeroCarta = numeroCarta;
		this.persone = persone; // Uncomment if needed later
		
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
//	public Set<PersonaDTO> getPersone() {
//		return persone;
//	}
//	public void setPersone(Set<PersonaDTO> persone) {
//		this.persone = persone;
//	}
	public String toString() {
		return "CartaDTO [id=" + id + ", numeroCarta=" + numeroCarta + ", persone=" + "]"; // Removed persone for simplicity
	}
	

}
