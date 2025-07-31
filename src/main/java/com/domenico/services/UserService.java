package com.domenico.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domenico.entities.User;
import com.domenico.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User salvaUtente(User user) {
		return userRepository.save(user);
	}
	public void salvaUtente2(User user) {
		userRepository.save(user);
	}
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	

}
