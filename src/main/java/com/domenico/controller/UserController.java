package com.domenico.controller;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.domenico.dto.UserDTO;
import com.domenico.entities.User;
import com.domenico.services.UserService;

@RestController
public class UserController {
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping("/api/user2")
	public void inserisciUtente2(@RequestBody User user) {
		if(user.getUsername() == "" || user.getPassword() == "") {
			LOGGER.warning("Username or password is null for user: " + user);
			user.setUsername(null);
			user.setPassword(null);
			
		}
		LOGGER.info("Inizio inserimento utente: " + user);
		userService.salvaUtente2(user);
		LOGGER.info("Utente inserito con successo: " + user);
		
	}
	
	@PostMapping("/api/user")
	public ResponseEntity<String> inserisciUtente(@RequestBody User user) {
		if(user.getUsername() == null || user.getPassword() == null) {
			LOGGER.warning("Username or password is null for user: " + user);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Username and password must not be null");
			
		}
		URI location = URI.create("/api/user/" + user.getUsername());
		LOGGER.info("Inizio inserimento utente: " + user);
		userService.salvaUtente(user);
		LOGGER.info("Utente inserito con successo: " + user);
		return ResponseEntity.status(HttpStatus.CREATED).header("location", "/api/user/" + user.getId())
		//return ResponseEntity.created(location).body("Utente inserito con successo: " + user.getUsername());
				.body("Utente inserito con successo: " + user.getUsername());
	}
	@GetMapping("/api/user")
	public ResponseEntity<List<User>>getUsers(){
		LOGGER.info("Inizio recupero utenti");
		List<User> users = userService.getAllUsers();
		if(users.isEmpty()) {
			LOGGER.warning("Nessun utente trovato");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(users);
		
	}
	@GetMapping("/api/user2")
	public List<User>getUser2(){
		return userService.getAllUsers();
	}
	@GetMapping("/api/user3")
	public List<UserDTO> getUser3(){
		return userService.getAllUsers2();
	}

}
