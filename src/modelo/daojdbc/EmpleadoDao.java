package modelo.daojdbc;
import java.util.List;
import modelo.javabean.Empleado;
public interface EmpleadoDao {
    public abstract List<Empleado> buscarTodos();
    public abstract Empleado buscarUno(int idEmpl);
    public abstract boolean altaEmpleado(Empleado empleado);
    public abstract boolean modificarEmpleado(Empleado empleado);
    public abstract boolean bajaEmpleado(int idEmpl);
    public abstract List<Empleado> empleadosByApellido(String apellido);
    public abstract List<Empleado> empleadosBySexo(char sexo);
    public abstract List<Empleado> empleadosByDepartamento(int idDepar);
    public abstract double salarioTotal();
    public abstract double salarioTotal(int idDepar);
}


