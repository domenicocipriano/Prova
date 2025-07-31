package com.domenico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domenico.entities.Carta;

public interface CartaRepository extends JpaRepository<Carta, Long> {
	// Qui puoi aggiungere metodi personalizzati per le query se necessario

}
