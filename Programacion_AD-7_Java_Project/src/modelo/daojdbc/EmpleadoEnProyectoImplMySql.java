package modelo.daojdbc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.javabean.EmpleadoEnProyecto;

public class EmpleadoEnProyectoImplMySql extends AbstractMySql implements EmpleadoEnProyectoDao {
	
	public List<EmpleadoEnProyecto> empleadosByProyecto(String codigoProyecto) {
		List<EmpleadoEnProyecto> lista = new ArrayList<>();
		EmpleadoImplMySql empleadoimpl1 = new EmpleadoImplMySql();
		ProyectoImplMySql proyectoimpl1 = new ProyectoImplMySql();
		try {
			ps = conn.prepareStatement("select * from proyecto_con_empleados where id_proyecto = ?");
			ps.setString(1, codigoProyecto);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmpleadoEnProyecto empep1 = new EmpleadoEnProyecto();
				empep1.setNumeroOrden(rs.getInt("numero_orden"));
				empep1.setEmpleado(empleadoimpl1.buscarUno(rs.getInt("id_empl")));
				empep1.setProyecto(proyectoimpl1.buscarUno(rs.getString("id_proyecto")));
				empep1.setHorasAsignadas(rs.getInt("horas_asignadas"));
				empep1.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
				lista.add(empep1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public int asignarEmpleadosAProyecto(List<EmpleadoEnProyecto> empleados) {
		//Por hacer
		return 0;
	}
	
	public int horasAsignadasAProyecto(String codigoProyecto) {
		//Por hacer
		return 0;
	}
	
	public double costeActualDeProyecto(String codigoProyecto) {
		//Por hacer
	    return 0;
	}
	
	public double margenActualProyecto(String codigoProyecto) {
		//Por hacer
		return 0;
	}
}

