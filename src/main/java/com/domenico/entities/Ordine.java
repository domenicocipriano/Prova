package com.domenico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_prodotto")
	private String nomeProdotto;
	private Double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false) //'user_id' chiave esterna che fa riferimento alla tabella User
	private User user;
	
	public Ordine() {
		// Default constructor for JPA
	}
	public Ordine(String nomeProdotto, Double prezzo, User user) {
		this.nomeProdotto = nomeProdotto;
		this.prezzo = prezzo;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String toString() {
		return "Ordine [id=" + id + ", nomeProdotto=" + nomeProdotto + ", prezzo=" + prezzo + ", user=" + user.getUsername() + "]";
	}
	
	

}
