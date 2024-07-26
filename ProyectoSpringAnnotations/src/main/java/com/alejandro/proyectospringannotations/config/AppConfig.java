/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alejandro.proyectospringannotations.config;

import com.alejandro.proyectospringannotations.models.CreacionInformes;
import com.alejandro.proyectospringannotations.models.Empleado;
import com.alejandro.proyectospringannotations.models.Informe;
import com.alejandro.proyectospringannotations.models.VicepresidenteEmpleado;
import java.net.http.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author aleja
 */
@PropertySource("classpath:datosEmpresa.properties")
@Configuration
@ComponentScan("com.alejandro.proyectospringannotations")
public class AppConfig{
    @Bean
    public HttpClient getHttpClient(){
        return HttpClient.newHttpClient();
    }
    @Bean(value = "miInforme")
    public CreacionInformes informe(){
        return new Informe();
    }

    @Bean
    public Empleado miEmpleado(){
        return new VicepresidenteEmpleado(informe());
    }
}
