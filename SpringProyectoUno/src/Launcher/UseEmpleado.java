package Launcher;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import IoC.*;

public class UseEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Como se hace normalmente (sin spring)
		//Creacion de los objetos
		Empleados empleado1=new DirectorEmpleados();
		//Uso de los objetos
		System.out.print(empleado1.getTareas());
		*/
		//USO DE SPRING Inversion of Control
		//1. Cargar Archivo xml
        ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Pedir el bean
        Empleados Juan= contexto.getBean("miJefe",Empleados.class);
        Empleados Alejo = contexto.getBean("miDirector",Empleados.class);
        SecretarioEmpleado Camilo = contexto.getBean("miSecretario",SecretarioEmpleado.class);
        SecretarioEmpleado Pablo = contexto.getBean("miSecretario",SecretarioEmpleado.class);
        DirectorEmpleados Christian = contexto.getBean("miDirector",DirectorEmpleados.class);
        //Utilizar el bean
        System.out.println(Juan.getTareas());
        System.out.println(Alejo.getTareas());
        System.out.println(Camilo.getTareas());
        //Cerrar el xml
        //Inyeccion de dependencia:
        //Mediante el constructor
        System.out.println(Juan.getInforme());
        System.out.println(Alejo.getInforme());
        //Mediante un metodo setter
        System.out.println(Camilo.getInforme());
        //Inyeccion de campos archivo xml
        System.out.println("Email Camilo: "+Camilo.getEmail());
        System.out.println("Empresa: "+Camilo.getNombreEmpresa());
        System.out.println("Email pablo: "+Pablo.getEmail());
        //Inyeccion de campos desde un archivo de propiedades
        System.out.println("Email Director Christian: "+Christian.getEmail());
        System.out.println("Empresa director christian: "+Christian.getNombreEmpresa());
	}
}
