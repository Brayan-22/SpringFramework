package com.alejandro.springmvc.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hola")
public class HolaControlador {
	
	/*
	 * Este metodo muestra el formulario al usuario
	 * 
	 */
	@RequestMapping(path = "/muestraFormulario")
	public String getFormulario() {
		return "holaFormulario";
	}
	
	@RequestMapping(path="/procesaFormulario",method = {RequestMethod.GET})
	public String procesaFormulario() {
		return "holaSpring";
	}
	
	@RequestMapping(path = "/otroProcesaFormulario")
	//public String otroProcesaFormulario(HttpServletRequest request, Model model) {
	public String otroProcesaFormulario(@RequestParam("nombre") String nombre, Model model) {
		nombre += "es el mejor";
		model.addAttribute("nombre",nombre);
		return "holaSpring";
	}
	
	
}
