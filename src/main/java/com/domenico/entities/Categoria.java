package com.domenico.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descrizione;
	
	@OneToMany(mappedBy = "categoria",orphanRemoval = true, cascade = CascadeType.ALL) // Associazioni con la classe Prodotto possono essere aggiunte se necessario
	private List<Prodotto> prodotti; // Associazioni con la classe Prodotto possono essere aggiunte se necessario
	
	public Categoria() {
		// Default constructor for JPA
	}
	public Categoria(String descrizione) {
		this.descrizione = descrizione;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String toString() {
		return "Categoria [id=" + id + ", descrizione=" + descrizione + "]";
	}

}
