package com.domenico.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false) // unique constraint to prevent duplicate usernames // and not null constraint
	private String username;
	@Column(unique = true, nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ordine>ordini;
	
	 @JsonBackReference // Indica che questa è la parte "non gestita" della relazione, utile per evitare loop infiniti durante la serializzazione JSON
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)   //mappedBy indica che la relazione è gestita dalla classe Persona e 
	// 'user' è il nome del campo nella classe Persona che fa riferimento a questa entità
	private Persona persona;
	
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User() {
		// Default constructor for JPA
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
//	public List<Ordine> getOrdini() {
//		return ordini;
//	}
	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", ordini=" + ordini + "]";
	}
	
	

}
