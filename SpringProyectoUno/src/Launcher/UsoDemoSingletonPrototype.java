package Launcher;
import IoC.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoDemoSingletonPrototype {

	public static void main(String[] args) {
		
		//Carga xml de configuracion
        ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //Peticion de beans al contenedor Spring
        
        SecretarioEmpleado Maria = contexto.getBean("miSecretario",SecretarioEmpleado.class);
        SecretarioEmpleado Pedro = contexto.getBean("miSecretario",SecretarioEmpleado.class);
        /*
         Demostracion de que Spring usa el patron singleton o prototype (dependiendo la configuracion scope del bean dada en el xml)
         */
        if(Maria==Pedro) System.out.println("Apuntan al mismo objeto");
        else System.out.println("No apuntan al mismo objeto");
	}
}
