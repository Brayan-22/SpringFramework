/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.alejandro.proyectospringannotations;

import com.alejandro.proyectospringannotations.config.AppConfig;
import org.springframework.context.ApplicationContext;
import com.alejandro.proyectospringannotations.models.Empleado;
import com.alejandro.proyectospringannotations.models.SecretarioEmpleado;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class ProyectoSpringAnnotations {
    
    public static void main(String[] args) {
        
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Empleado empleado1 = context.getBean("miEmpleado", Empleado.class);
        System.out.println(empleado1.getInforme());
        Empleado empleado2 = context.getBean("miEmpleado2",Empleado.class);
        System.out.println(empleado2.getInforme());
        SecretarioEmpleado secretario = context.getBean("miEmpleado3",SecretarioEmpleado.class);
        System.out.println("Email: "+secretario.getEmail());
        ((ConfigurableApplicationContext)context).close();
    }
}
