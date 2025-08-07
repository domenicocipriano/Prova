package com.domenico.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.domenico.dto.UserDTO;
import com.domenico.entities.User;
import com.domenico.models.UserMapper;
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
	
	public List<UserDTO> getAllUsers2(){
		return userRepository.findAll().stream()
				.map(UserMapper::toDTO)
                .collect(Collectors.toList());
		
	}

}
