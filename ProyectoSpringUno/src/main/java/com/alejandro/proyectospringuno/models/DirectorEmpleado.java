/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejandro.proyectospringuno.models;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class DirectorEmpleado implements Empleado {

    private CreacionInformes creacionInformes;
    
    public DirectorEmpleado(@Autowired @Qualifier("miInforme")CreacionInformes creacionInformes){
        this.creacionInformes = creacionInformes;
    }
    
    @Override
    public String getTareas() {
        return "Gestiona la plantilla de la empresa";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el director: "+creacionInformes.getInforme();
    }
    
    public void inicial(){
        System.out.println("Tarea ejecutada antes de la creacion del bean");
    }
    public void destruir(){
        System.out.println("Tarea ejecutada después de terminar el programa");
    }
    
}
