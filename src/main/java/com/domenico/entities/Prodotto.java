package com.domenico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Prodotto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descrizione;
	private Double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false) // 'categoria_id' chiave esterna che fa riferimento alla tabella Categoria
	private Categoria categoria; // Associazioni con la classe Categoria possono essere aggiunte se necessario
	
	public Prodotto() {
		// Default constructor for JPA
	}
	public Prodotto(Long id, String descrizione, Double prezzo) {
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
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
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public String toString() {
		return "Prodotto [id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
	}
	

}
