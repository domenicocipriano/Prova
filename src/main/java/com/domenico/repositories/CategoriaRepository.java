package com.domenico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domenico.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	// Qui puoi aggiungere metodi personalizzati per le query se necessario

}
