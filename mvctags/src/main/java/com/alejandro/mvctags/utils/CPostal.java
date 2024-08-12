package com.alejandro.mvctags.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.alejandro.mvctags.utils.impl.CPostalImpl;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = CPostalImpl.class)// clase que contiene la logica de la validacion
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPostal {
	
	// definir el codigo postal por defecto
	public String value() default "28";
	// definir el mensaje de error
	public String message() default "Codigo postal debe comenzar por 28";	
	//definir los grupos
	Class<?>[] groups() default {};
	//definir los payloads
	Class<? extends Payload>[] payload() default {}; 
}
