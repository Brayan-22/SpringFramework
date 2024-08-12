package com.alejandro.mvctags.utils.impl;

import com.alejandro.mvctags.utils.CPostal;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPostalImpl implements ConstraintValidator<CPostal, String>{
	
	@Override
	public void initialize(CPostal constraintAnnotation) {
		prefijoCodigoPostal = constraintAnnotation.value();
		message = constraintAnnotation.message();
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean valCodigo;
		if (value != null) valCodigo = value.startsWith(prefijoCodigoPostal);
		else return valCodigo = true;
		return valCodigo;
	}
	
	private String prefijoCodigoPostal;
	private String message;

}
