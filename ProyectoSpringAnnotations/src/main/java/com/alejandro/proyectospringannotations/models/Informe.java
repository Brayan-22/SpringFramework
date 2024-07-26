
package com.alejandro.proyectospringannotations.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Informe implements CreacionInformes {

    @Override
    public String getInforme() {
        return "Esta es la presentacion del informe";
    }
    
}
