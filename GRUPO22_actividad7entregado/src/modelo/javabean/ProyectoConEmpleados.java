package modelo.javabean;

import java.sql.Date;
public class ProyectoConEmpleados {
    //Atributos de instancia
	private int numeroOrden;
	private Proyecto proyecto;
	private Empleado empleado;
	private int horasAsignadas;
	private Date fechaIncorporacion;
	
	public ProyectoConEmpleados(int numeroOrden, Proyecto proyecto, Empleado empleado, int horasAsignadas,
			Date fechaIncorporacion) {
		super();
		this.numeroOrden = numeroOrden;
		this.proyecto = proyecto;
		this.empleado = empleado;
		this.horasAsignadas = horasAsignadas;
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public int getHorasAsignadas() {
		return horasAsignadas;
	}
	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}
	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}
	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	@Override
	public String toString() {
		return "ProyectoConEmpleados [numeroOrden=" + numeroOrden + ", proyecto=" + proyecto + ", empleado=" + empleado
				+ ", horasAsignadas=" + horasAsignadas + ", fechaIncorporacion=" + fechaIncorporacion + "]";
	}

}
