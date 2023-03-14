package testing;
import java.sql.Date;

import modelo.daojdbc.DepartamentoImplMySql;
import modelo.daojdbc.EmpleadoImplMySql;
import modelo.daojdbc.PerfilImplMySql;
import modelo.javabean.Empleado;

public class TestEmpleadoImpl {

	public static void main(String[] args) {

		EmpleadoImplMySql empimpl1 = new EmpleadoImplMySql();
		
		//Métodos DML-select-------------------------------------------------------------
        //1
		System.out.println("Lista de todos los empleados:");
		for (Empleado ele: empimpl1.buscarTodos())
			System.out.println(ele);
		//2
		System.out.println("Datos de un empleado dado su idEmpl:");
		System.out.println(empimpl1.buscarUno(116));
		//3
		System.out.println("Empleados de ese apellido:");
		for (Empleado ele: empimpl1.empleadosByApellido("koo"))
			System.out.println(ele);
		//4
		System.out.println("Empleados de ese sexo:");
		for (Empleado ele: empimpl1.empleadosBySexo('H'))
			System.out.println(ele);

		//5
		System.out.println("Empleados de ese departamento:");
		for (Empleado ele: empimpl1.empleadosByDepartamento(10))
			System.out.println(ele);

        //Métodos DML-insert-----------------------------------------------------------------------
    	PerfilImplMySql perfilimpl1 = new PerfilImplMySql();
    	DepartamentoImplMySql dptoimpl1 = new DepartamentoImplMySql();
    	System.out.println("Nuevo empleado a nivel de java");
    	Empleado empleado1 = new  Empleado(999, "Olivia", "Pérez Martínez", 'M', "olpema@tt.com", "contraseña",
    			30000, Date.valueOf("2011-02-15"), Date.valueOf("2011-02-15"), 
    			perfilimpl1.buscarUno(4), dptoimpl1.buscarUno(40));
		System.out.println("Insercción en sql de ese empleado (devuelve 1 si el insert es satisfactorio)");
		System.out.println(empimpl1.altaEmpleado(empleado1));
		
		System.out.println("Buscar un empleado por idEmpl");
		System.out.println(empimpl1.buscarUno(999));
		
		//Métodos DML-update---------------------------------------------------------------------
		System.out.println("Modificación en java de datos de ese empleado");
		/*Ojo NO funciona empimpl1.buscarUno(999).setSalario(35000)*/;		
		empleado1.setSalario(33000);
		System.out.println(empleado1.getSalario());
		System.out.println("Actualización en sql de datos de ese empleado");
		System.out.println(empimpl1.modificarEmpleado(empleado1));
		System.out.println(empimpl1.buscarUno(999));
		
		//Métodos DML-delete------------------------------------------------------------------------
		System.out.println("Dar de baja a ese empleado (devuelve 1 si el delete es satisfactorio)");
		System.out.println(empimpl1.bajaEmpleado(999));
		
		//9
		System.out.println("Suma de todos los salarios:");
		System.out.println(empimpl1.salarioTotal());
		//10
		System.out.println("Suma de todos los salarios de ese departamento:");
		System.out.println(empimpl1.salarioTotal(10));
		
	}

}
