package com.domenico.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domenico.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	List<Persona>findByNome(String nome);
	List<Persona> findByCognome(String cognome);

	
	
	
}
