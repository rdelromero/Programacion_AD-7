package testing;
import modelo.daojdbc.PerfilImplMySql;

public class TestPerfilImpl {
    public static void main(String[] args) {
    	PerfilImplMySql perfil1= new PerfilImplMySql();
    	System.out.println("Datos de ese perfil:");
    	System.out.println(perfil1.buscarUno(1));
    }
}
