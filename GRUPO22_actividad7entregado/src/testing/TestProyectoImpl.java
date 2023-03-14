package testing;
import modelo.daojdbc.ProyectoImplMySql;
import modelo.javabean.Proyecto;

public class TestProyectoImpl {
    public static void main(String[] args) {
    	
		ProyectoImplMySql proimpl1 = new ProyectoImplMySql();
    	
		System.out.println("Lista de todos los proyectos");
		for (Proyecto ele: proimpl1.buscarTodos())
		    System.out.println(ele);
		
		System.out.println("Buscar un proyecto por idProyecto");
		System.out.println(proimpl1.buscarUno("FOR2021001"));
		
		System.out.println("Proyectos con ese estado:");
		for (Proyecto ele: proimpl1.proyectosByEstado("terminado"))
		    System.out.println(ele);
		
		System.out.println("Proyectos de ese cliente:");
		for (Proyecto ele: proimpl1.proyectosByCliente("B33333333"))
	        System.out.println(ele);
		
		System.out.println("Proyectos con ese jefeProyecto y con ese estado:");
		for (Proyecto ele: proimpl1.proyectosByJefeProyectoAndByEstado(114, "activo"))
            System.out.println(ele);
		
		System.out.println("Venta prevista total entre todos los proyectos terminados");
		System.out.println(proimpl1.importeVentaProyectosTerminados());
		
		System.out.println("Diferencia total entre venta previsto y coste real entre todos los proyectos terminados:");
		System.out.println(proimpl1.margenBrutoProyectosTerminados());
		
		System.out.println("Días que que llege la fecha fin prevista de ese proyecto:");
		System.out.println(proimpl1.diasATerminoProyectoActivo("FOR2020001"));
		
		/*----------------------------------------------------------------------------------------
		
		System.out.println("Diferencia entre fecha fin prevista y fecha fin real para ese proyecto:");
		System.out.println(proimpl1.diferenciaFinPrevistoReal("FOR2021001"));
		
		System.out.println("Diferencia entre fecha fin prevista y fecha fin real para cada proyecto");
		for (ArrayList<Object> ele: proimpl1.diferenciaFinPrevistoReal2())
			System.out.println(ele);
    	*/
    }
}


