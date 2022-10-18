package IoC;

public class DirectorEmpleados implements Empleados {
	//Creacion de campo tipo creacionInforme(interfaz)
	private CreacionInformes informeNuevo;
	private String email;
	private String nombreEmpresa;
	//Creacion de constructor que inyecta la dependencia
	public DirectorEmpleados(CreacionInformes informeNuevo) {
		this.informeNuevo=informeNuevo;
	}
	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Soy el director";
	}
	
	@Override
	public String getInforme() {
		return "Informe creado por el director:" + informeNuevo.getInforme();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
}
