package testing;
import modelo.daojdbc.DepartamentoImplMySql;

public class TestDepartamentoImpl {

	public static void main(String[] args) {
	
	DepartamentoImplMySql dpto1= new DepartamentoImplMySql();
	System.out.println("Datos de ese departamento:");
	System.out.println(dpto1.buscarUno(20));
	
	}
}
