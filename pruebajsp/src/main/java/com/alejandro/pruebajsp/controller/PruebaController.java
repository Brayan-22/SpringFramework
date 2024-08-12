package com.alejandro.pruebajsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prueba")
public class PruebaController {

	
	@GetMapping("/inicio")
	public String getIndex() {
		return "index";
	}
	
}
