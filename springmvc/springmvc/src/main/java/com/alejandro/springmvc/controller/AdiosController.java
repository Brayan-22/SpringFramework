package com.alejandro.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/adios")
public class AdiosController {
	@RequestMapping(path = "/otroProcesaFormulario")
	//public String otroProcesaFormulario(HttpServletRequest request, Model model) {
	public String otroProcesaFormulario(@RequestParam("nombre") String nombre, Model model) {
		nombre += "es el peor";
		model.addAttribute("nombre",nombre);
		return "holaSpring";
	}
}
