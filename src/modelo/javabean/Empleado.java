package modelo.javabean;
import java.sql.Date;
public class Empleado {
    //Atributos de instancia
	private int idEmpl;
	private String nombre, apellidos;
	private char sexo;
	private String email, password;
	private double salario;
	private Date fechaIngreso, fechaNacimiento;
	private Perfil perfil; private Departamento departamento;

	//Métodos constructores
	public Empleado() {
	}
	public Empleado(int idEmpl, String nombre, String apellidos, char sexo, String email, String password,
			double salario, Date fechaIngreso, Date fechaNacimiento, Perfil perfil, Departamento departamento) {
		super();
		this.idEmpl = idEmpl;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.perfil = perfil;
		this.departamento = departamento;
	}
	
	//Métodos getter
	public int getIdEmpl() {
		return idEmpl;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public char getSexo() {
		return sexo;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public double getSalario() {
		return salario;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	//Métodos setter
	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo
				+ ", email=" + email + ", password=" + password + ", salario=" + salario + ", fechaIngreso="
				+ fechaIngreso + ", fechaNacimiento=" + fechaNacimiento + ", perfil=" + perfil + ", departamento="
				+ departamento + "]";
	}

	//Métodos public no static propios
	public String nombreCompleto() {
		return nombre+" "+apellidos;
	}
	public double salarioMensual(int meses) {
		return salario/meses;
	}
	public String obtenerEmail() {
		String apellidosminusculas=this.apellidos.toLowerCase();
		int posprimerapellido=apellidosminusculas.indexOf(' ');
		return nombre.charAt(0)+apellidosminusculas.substring(0,posprimerapellido);
	}
	public String literalSexo() {
		if (this.sexo=='H') {
			return "Hombre";
		}
		if (this.sexo=='M') {
			return "Mujer";
		}
		else
			return "Desconocido";
	}
	
}
