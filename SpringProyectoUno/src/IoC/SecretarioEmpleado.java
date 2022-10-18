package IoC;

public class SecretarioEmpleado implements Empleados {
	private CreacionInformes informeNuevo;
	private String email;
	private String nombreEmpresa;
	public SecretarioEmpleado() {
	}
	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Soy el secretario";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe generado por el secretario encargado "+informeNuevo.getInforme();
	}
	public void setInformeNuevo(CreacionInformes informeNuevo) {
		this.informeNuevo=informeNuevo;
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
