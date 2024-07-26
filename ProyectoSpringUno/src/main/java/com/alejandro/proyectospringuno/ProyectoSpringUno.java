/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.alejandro.proyectospringuno;

import org.springframework.context.ApplicationContext;
import com.alejandro.proyectospringuno.models.Empleado;
import com.alejandro.proyectospringuno.models.SecretarioEmpleado;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class ProyectoSpringUno {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Empleado empleado1 = context.getBean("miEmpleado", Empleado.class);
        System.out.println(empleado1.getInforme());
        Empleado empleado2 = context.getBean("miEmpleado3",Empleado.class);
        System.out.println(empleado2.getInforme());
        SecretarioEmpleado secretario = context.getBean("miEmpleado3",SecretarioEmpleado.class);
        System.out.println("Email: "+secretario.getEmail());
        ((ConfigurableApplicationContext)context).close();
        Properties properties = new Properties();
        ClassLoader classLoader = ProyectoSpringUno.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("datosEmpresa.properties")){
            if (inputStream == null) {
                System.out.println("Archivo no encontrado");
                return;
            }
            properties.load(inputStream);
            var nombreEmpresa = properties.getProperty("nombreEmpresa");
            var email = properties.getProperty("email");
            System.out.println(nombreEmpresa);
            System.out.println(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
