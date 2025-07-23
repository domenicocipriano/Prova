package com.domenico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domenico.entities.Indirizzo;

public interface IndirizzoRepository extends JpaRepository<Indirizzo, Integer> {
	// This interface will automatically provide CRUD operations for the Indirizzo entity
	// No additional methods are needed unless you want to define custom queries

}
