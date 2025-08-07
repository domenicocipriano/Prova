package com.domenico.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domenico.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	List<Persona>findByNome(String nome);
	List<Persona> findByCognome(String cognome);
	

	
	
	
}
