package com.alejandro.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(path = "/home")
	public String getHome() {
		return "paginaEjemplo";
	}
}
