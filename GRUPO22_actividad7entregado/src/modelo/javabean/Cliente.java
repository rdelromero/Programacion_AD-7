package modelo.javabean;

public class Cliente {
    //Atributos de instancia
	private String cif, nombre, apellidos, domicilio;
	private double facturacionAnual;
	private int numeroEmpleados;
	
	public Cliente() {
	}
	
	public Cliente(String cif, String nombre, String apellidos, String domicilio, double facturacionAnual,
			int numeroEmpleados) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.facturacionAnual = facturacionAnual;
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getCif() {
		return cif;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public double getFacturacionAnual() {
		return facturacionAnual;
	}
	public int getNumeroEmpleados() {
		return numeroEmpleados;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public void setFacturacionAnual(double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}
	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio=" + domicilio
				+ ", facturacionAnual=" + facturacionAnual + ", numeroEmpleados=" + numeroEmpleados + "]";
	}

}
