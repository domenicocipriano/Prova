package com.domenico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domenico.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
