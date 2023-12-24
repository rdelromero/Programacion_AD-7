package testing;
import java.sql.Date;
import modelo.javabean.Departamento;
import modelo.javabean.Perfil;
import modelo.javabean.Empleado;

public class TestEmpleado {
    public static void main (String[] args) {
    	
    	Perfil perfil1 = new Perfil(9, "N/A");
    	Departamento dpto1 = new Departamento(99, "Atención al cliente", "N/A");
    	Empleado empleado1 = new  Empleado(999, "Olivia", "Pérez Martínez", 'M', "olpema@tt.com", null,
    			30000, Date.valueOf("2011-02-15"), Date.valueOf("2011-02-15"), perfil1, dpto1);
        
    	//Probando que los métodos de la clase Empleado funcionan
    	System.out.println(empleado1.salarioMensual(12));
    	System.out.println(empleado1.literalSexo());
    	System.out.println(empleado1.obtenerEmail());
    	System.out.println(empleado1.nombreCompleto());	
    }
}
