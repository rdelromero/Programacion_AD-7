package modelo.javabean;


public class Departamento {
    //Atributos de instancia
	private int idDepar;
	private String nombre, direccion;
	
	public Departamento() {
	}

	public Departamento(int idDepar, String nombre, String direccion) {
		this.idDepar = idDepar; this.nombre = nombre; this.direccion = direccion;
	}

	public int getIdDepar() {
		return idDepar;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

}
