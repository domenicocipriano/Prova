package com.domenico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	
public class IndexController {
	
	@GetMapping("/index")
	@ResponseBody //restituisce una risposta direttamente al client, senza passare per una vista in Json
	public String index() {
		return "Hello word!!!"; // Assuming you have an index.html in your templates folder
	}
	
}
