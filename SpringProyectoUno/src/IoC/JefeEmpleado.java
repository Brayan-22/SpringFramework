package IoC;

public class JefeEmpleado implements Empleados {
	private  CreacionInformes informeNuevo;
	private String email;
	private String nombreEmpresa;
	public JefeEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo=informeNuevo;
	}
	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Soy el jefe de los empleados";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe generado por el Jefe con correcciones "+informeNuevo.getInforme();
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
