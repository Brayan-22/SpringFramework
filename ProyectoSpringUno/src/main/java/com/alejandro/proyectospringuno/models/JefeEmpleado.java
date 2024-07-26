/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejandro.proyectospringuno.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class JefeEmpleado implements Empleado{
    
    private CreacionInformes creacionInformes;
    public JefeEmpleado(CreacionInformes creacionInformes){
        this.creacionInformes = creacionInformes;
    }
    @Override
    public String getTareas(){
        return "Gestiona las cuestiones relativas a los empleados de seccion";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el Jefe: "+creacionInformes.getInforme();
    }
}
