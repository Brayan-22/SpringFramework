package com.alejandro.mvctags.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alejandro.mvctags.models.Alumno;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	
	@InitBinder
	public void myBinder(WebDataBinder binder) {
		StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, trimmerEditor);
	}
	
	
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("alumno", alumno);
		return "alumnoRegistroFormulario";
	}

	@RequestMapping("/procesarFormulario")
	public String procesaFormulario(@ModelAttribute("alumno") @Valid Alumno alumno,BindingResult result) {
		return result.hasErrors()?"alumnoRegistroFormulario":"confirmacionRegistroAlumno";
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
}
