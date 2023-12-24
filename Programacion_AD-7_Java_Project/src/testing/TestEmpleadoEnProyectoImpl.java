package testing;
import modelo.daojdbc.EmpleadoEnProyectoImplMySql;
import modelo.javabean.EmpleadoEnProyecto;

public class TestEmpleadoEnProyectoImpl {

	public static void main(String[] args) {

		EmpleadoEnProyectoImplMySql empepimpl1 = new EmpleadoEnProyectoImplMySql();
		
		//Métodos DML-select-------------------------------------------------------------
		System.out.println("Empleados en ese proyecto:");
		for (EmpleadoEnProyecto elemento: empepimpl1.empleadosByProyecto("FOR2020001"))
			System.out.println(elemento);

		/*Falta probar asignarEmpleadosAProyecto(List<EmpleadoEnProyecto> empleados); 
		 * horasAsignadasAProyecto(String codigoProyecto);
		 * costeActualDeProyecto(String codigoProyecto);
		 * margenActualProyecto(String codigoProyecto);
		 */
		
	}

}

