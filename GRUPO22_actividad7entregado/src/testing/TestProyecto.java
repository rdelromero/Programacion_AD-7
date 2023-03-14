package testing;
import java.sql.Date;

import modelo.javabean.Cliente;
import modelo.javabean.Departamento;
import modelo.javabean.Empleado;
import modelo.javabean.Perfil;
import modelo.javabean.Proyecto;
public class TestProyecto {
    public static void main (String[] args) {
    	
    	Perfil perfil1 = new Perfil(9, "N/A");
    	Departamento dpto1 = new Departamento(99, "Atención al cliente", "N/A");
    	Cliente cliente1 = new Cliente("Z00000000", "Zacarías", "Zárate", "Zaragoza", 9999999, 200);
    	Empleado empleado1 = new  Empleado(999, "Olivia", "Pérez Martínez", 'M', "olpema@tt.com", null,
    			30000, Date.valueOf("2011-02-15"), Date.valueOf("2011-02-15"), perfil1, dpto1);
    	Proyecto proy1 = new Proyecto ("FOR2021999", null, Date.valueOf("2020-01-01"), Date.valueOf("2020-09-01"), Date.valueOf("2020-11-01"),
    			99999, 75000, 80000, "terminado", empleado1, cliente1);
    	
    	//Probando que los métodos de la clase Empleado funcionan
    	System.out.println(proy1.diferenciaGastos());	
    	System.out.println(proy1.diferenciaFinPrevistoReal());	
    	
    }
}