package modelo.javabean;
import java.sql.Date;
public class Proyecto {
    //Atributos de instancia
	private String idProyecto;
	private String descripcion;
	private Date fechaInicio, fechaFinPrevisto, fechaFinReal;
	private double ventaPrevisto, costesPrevisto, costeReal;
	private String estado;
	private Empleado jefeProyecto;
	private Cliente cif;
	
	//Métodos constructores
	public Proyecto() {
	}
	public Proyecto(String idProyecto, String descripcion, Date fechaInicio, Date fechaFinPrevisto, Date fechaFinReal,
			int ventaPrevisto, int costesPrevisto, int costeReal, String estado, Empleado jefeProyecto, Cliente cif) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventaPrevisto = ventaPrevisto;
		this.costesPrevisto = costesPrevisto;
		this.costeReal = costeReal;
		this.estado = estado;
		this.jefeProyecto = jefeProyecto;
		this.cif = cif;
	}
	
	//Métodos getter
	public String getIdProyecto() {
		return idProyecto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFinPrevisto() {
		return fechaFinPrevisto;
	}
	public Date getFechaFinReal() {
		return fechaFinReal;
	}
	public double getVentaPrevisto() {
		return ventaPrevisto;
	}
	public double getCostesPrevisto() {
		return costesPrevisto;
	}
	public double getCosteReal() {
		return costeReal;
	}
	public String getEstado() {
		return estado;
	}
	public Empleado getJefeProyecto() {
		return jefeProyecto;
	}
	public Cliente getCif() {
		return cif;
	}
	//Métodos setter
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}
	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}
	public void setVentaPrevisto(double ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}
	public void setCostesPrevisto(double costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}
	public void setCosteReal(double costeReal) {
		this.costeReal = costeReal;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}
	public void setCif(Cliente cif) {
		this.cif = cif;
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal=" + fechaFinReal + ", ventaPrevisto="
				+ ventaPrevisto + ", costesPrevisto=" + costesPrevisto + ", costeReal=" + costeReal + ", estado="
				+ estado + ", jefeProyecto=" + jefeProyecto + ", cif=" + cif + "]";
	}
    
	//Métodos propios
	public double diferenciaGastos() {
		return costeReal - costesPrevisto;
	}
	
	public long diferenciaFinPrevistoReal() {
        return (fechaFinPrevisto.getTime() - fechaFinReal.getTime())/86400000;
    }

}
