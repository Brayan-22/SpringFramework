/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejandro.proyectospringannotations.models;

/**
 *
 * @author alejandro
 */
public class VicepresidenteEmpleado implements Empleado {
    private CreacionInformes creacionInformes;
    public VicepresidenteEmpleado(CreacionInformes informes){
        this.creacionInformes = informes;
    }
    @Override
    public String getTareas() {
        return "Vicepresidente";
    }

    @Override
    public String getInforme() {
        return "Informe de vicepresidente"+creacionInformes.getInforme();
    }
    
}
