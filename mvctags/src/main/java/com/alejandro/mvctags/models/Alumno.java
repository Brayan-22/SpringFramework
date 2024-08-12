package com.alejandro.mvctags.models;

import com.alejandro.mvctags.utils.CPostal;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Alumno {
	@NotNull
	@Size(min = 2,message = "El campo no debe estar vacio o debe tener mas de 2 caracteres")
	private String nombre;
	private String apellido;
	private String optativa;
	private String ciudadEstudios;
	@Min(value = 10,message = "No se permiten edades menores de 10")
	@Max(value = 100,message = "No se permiten edades mayores a 100")
	private int edad;
	private String idiomas;
	//@Pattern(regexp = "[0-9]{5}",message = "codigo postal no valido")
	@CPostal
	private String codigoPostal;
	@Email
	private String email;
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	public String getCiudadEstudios() {
		return ciudadEstudios;
	}
	public void setCiudadEstudios(String ciudadEstudios) {
		this.ciudadEstudios = ciudadEstudios;
	}
	public String getOptativa() {
		return optativa;
	}
	public void setOptativa(String optativa) {
		this.optativa = optativa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Alumno(String nombre, String apellido,String optativa,
			String ciudadEstudios,String idiomas,int edad,String email,String codigoPostal) {
		super();
		this.codigoPostal = codigoPostal;
		this.email = email;
		this.edad = edad;
		this.idiomas = idiomas;
		this.nombre = nombre;
		this.optativa = optativa;
		this.apellido = apellido;
		this.ciudadEstudios = ciudadEstudios;
	}
	public Alumno() {
		super();
	}
}
