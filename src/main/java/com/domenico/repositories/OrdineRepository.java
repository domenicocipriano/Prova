package com.domenico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domenico.entities.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {
	// Custom query methods can be defined here if needed

}
