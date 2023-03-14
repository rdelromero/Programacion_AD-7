package modelo.daojdbc;

import java.util.List;

import modelo.javabean.Proyecto;

public interface ProyectoDao {
	public abstract List<Proyecto> buscarTodos();
	public abstract Proyecto buscarUno(String idProyecto); 
	public abstract List<Proyecto> proyectosByEstado(String estado);
	public abstract List<Proyecto> proyectosByCliente(String cif);
	public abstract List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado);
	public abstract double importeVentaProyectosTerminados();
	public abstract double margenBrutoProyectosTerminados();
	public abstract int diasATerminoProyectoActivo(String idProyecto);
}
