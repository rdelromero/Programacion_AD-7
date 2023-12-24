package modelo.daojdbc;
import java.util.List;
import modelo.javabean.EmpleadoEnProyecto;

public interface EmpleadoEnProyectoDao {
	public abstract List<EmpleadoEnProyecto> empleadosByProyecto(String codigoProyecto);
	public abstract int asignarEmpleadosAProyecto(List<EmpleadoEnProyecto> empleados); 
	public abstract int horasAsignadasAProyecto(String codigoProyecto);
	public abstract double costeActualDeProyecto(String codigoProyecto);
	public abstract double margenActualProyecto(String codigoProyecto);
}
