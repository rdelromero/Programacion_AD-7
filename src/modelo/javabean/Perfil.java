package modelo.javabean;
public class Perfil {
    //Atributos de instancia
	private int idPerfil;
	private String nombre;
	
	//Métodos constructores
	public Perfil() {
	}
	public Perfil(int idPerfil, String nombre) {
		this.idPerfil = idPerfil;
		this.nombre = nombre;
	}

	//Métodos getter
	public int getIdPerfil() {
		return idPerfil;
	}
	public String getNombre() {
		return nombre;
	}
	//Métodos setter
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", nombre=" + nombre + "]";
	}
	
}

