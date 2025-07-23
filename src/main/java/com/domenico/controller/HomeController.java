package com.domenico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domenico.entities.Persona;
import com.domenico.services.PersonaService;

@Controller
public class HomeController {
	@Autowired
	private PersonaService personaService;
	
    @GetMapping("/")
	public String welcome() {
		return "Welcome to the home page!";	//indica la vista della pagina home
	}
    @GetMapping("/index1")
   
    public String welcome2(Model model) {
    	model.addAttribute("message", "Welcome to the index page!");
    	return "index";
    }
    @ResponseBody	// quando si usa @ResponseBody, il metodo restituisce direttamente il corpo della risposta HTTP
    @GetMapping("/index2")
    public String welcome3() {
    	return "ciao";
    }
    @GetMapping("/new")
    public String newPage() {
		return "newPersona"; // Assuming you have a new.html in your templates folder
	}
    @PostMapping("/persona")
    public String creaPersona(@ModelAttribute Persona persona, Model model,ModelMap map) {
		// Logica per creare una persona
		personaService.creaPersona(persona);
		model.addAttribute("nome", persona.getNome());
		//model.addAttribute("cognome", persona.getCognome());
		map.put("cognome", persona.getCognome());
		return "persona_success"; // Redirect to the index page after creation
	}
    @GetMapping("/redirect")
    public String redirect() {
	   return "redirect:/new";
   }
    
}
