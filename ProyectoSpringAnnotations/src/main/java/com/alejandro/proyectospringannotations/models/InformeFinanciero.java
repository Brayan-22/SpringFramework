/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejandro.proyectospringannotations.models;

import org.springframework.stereotype.Component;

@Component
public class InformeFinanciero implements CreacionInformes {

    @Override
    public String getInforme() {
        return "Creacion de informe financiero";
    }
    
}
