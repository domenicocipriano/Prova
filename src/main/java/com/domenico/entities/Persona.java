package com.domenico.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;




@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	
	@OneToOne(cascade = CascadeType.ALL)  //CascadeType.ALL indica che tutte le operazioni (persist, merge,remove, refresh, detach) saranno propagate all'entità Indirizzo
	@JoinColumn(name = "indirizzo_id", referencedColumnName = "id")  //campo 'indirizzo_id' nella tabella Persona che fa riferimento alla tabella Indirizzo
	private Indirizzo indirizzo;	//referencedColumn indica che la colonna 'id' della tabella Indirizzo è quella a cui si fa riferimento
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	// Utilizzato per evitare la serializzazione circolare tra Persona e Carta
	@ManyToMany
	@JoinTable(name = "persona_carta",joinColumns = @JoinColumn(name = "persona_id"), 
			   inverseJoinColumns = @JoinColumn(name = "carta_id")) //joinColumn indica la colonna che fa riferimento alla tabella Persona, inverseJoinColumns indica la colonna che fa riferimento alla tabella Carte
	private Set<Carta> carte; // Associazioni con la classe Carte possono essere aggiunte se necessario
	
	public Persona() {
	}

	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	private Persona(String nome, String cognome, Indirizzo indirizzo) {
		this(nome, cognome);
		this.indirizzo = indirizzo;
	}
	public Persona(String nome, String cognome, Indirizzo indirizzo, User user) {
		this(nome, cognome, indirizzo);
		this.user = user;
	}
	public Persona(String nome, String cognome, Indirizzo indirizzo, User user, Set<Carta> carte) {
		this(nome, cognome, indirizzo, user);
		this.carte = carte;
	}

	public Set<Carta> getCarte() {
		return carte;
	}

	public void setCarte(Set<Carta> carte) {
		this.carte = carte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
//	public void aggiungiCarta(Carta carta) {
//		carte.add(carta);
//		carta.getPersone().add(this); // Assicurati che la relazione sia bidirezionale
//	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "," + indirizzo + ","
				+ user + "]";
	}

	
	
	
	
	
	
	
	
	

}
