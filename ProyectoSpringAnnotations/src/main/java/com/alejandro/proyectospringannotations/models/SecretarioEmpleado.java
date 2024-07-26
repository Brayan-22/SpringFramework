package com.alejandro.proyectospringannotations.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "miEmpleado3")
@Scope("singleton")
public class SecretarioEmpleado implements Empleado {
    private CreacionInformes creacionInformes;
    private String email;
    private String nombreEmpresa;
    
    @Override
    public String getTareas() {
        return "Gestionar la agenda de los jefes";
    }

    @Override
    public String getInforme() {
        return "Reporte creado por el secretario: "+creacionInformes.getInforme();
    }
    
    @Autowired 
    @Qualifier("miInforme")
    public void setCreacionInformes(CreacionInformes creacionInformes) {
        this.creacionInformes = creacionInformes;
    }

    public String getEmail() {
        return email;
    }
    @Value("${email}")
    public void setEmail(String email) {
        this.email = email;
    }

    @Value("${nombreEmpresa}")
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    
    
}
