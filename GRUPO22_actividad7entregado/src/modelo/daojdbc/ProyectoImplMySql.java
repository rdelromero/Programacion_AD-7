package modelo.daojdbc;
import java.sql.SQLException;
import java.util.ArrayList; import java.util.Arrays;
import java.util.List;

import modelo.javabean.Empleado;
import modelo.javabean.Proyecto;
public class ProyectoImplMySql extends AbstractMySql implements ProyectoDao{

	//Métodos DML-select---------------------------------------------------------------------------
	
	public List<Proyecto> buscarTodos() {
		sql = "select * from proyectos";
		List<Proyecto> lista = new ArrayList<>();
	    ClienteImplMySql cliimpl1 = new ClienteImplMySql();
	    EmpleadoImplMySql empimpl1 = new EmpleadoImplMySql();
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
			    Proyecto pro1 = new Proyecto();
			    pro1.setIdProyecto(rs.getString("id_proyecto"));
			    pro1.setDescripcion(rs.getString("descripcion"));
			    pro1.setFechaInicio(rs.getDate("fecha_inicio"));
			    pro1.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
			    pro1.setFechaFinReal(rs.getDate("fecha_fin_real"));
			    pro1.setVentaPrevisto(rs.getDouble("venta_previsto"));
			    pro1.setCostesPrevisto(rs.getDouble("costes_previsto"));
			    pro1.setCosteReal(rs.getDouble("coste_real"));
			    pro1.setEstado(rs.getString("estado"));
			    pro1.setJefeProyecto(empimpl1.buscarUno(rs.getInt("jefe_proyecto")));   
			    pro1.setCif(cliimpl1.buscarUno(rs.getString("cif")));   
			    lista.add(pro1);	    
			}
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return lista;
	}
	
	public Proyecto buscarUno(String idProyecto) {
		sql = "select * from proyectos where id_proyecto = ?";
		Proyecto pro1 = null;
		ClienteImplMySql cliimpl1 = new ClienteImplMySql();
		EmpleadoImplMySql empimpl1 = new EmpleadoImplMySql();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			if (rs.next()) {
				pro1 = new Proyecto();
				pro1.setIdProyecto(rs.getString("id_proyecto"));
				pro1.setDescripcion(rs.getString("descripcion"));
				pro1.setFechaInicio(rs.getDate("fecha_inicio"));
				pro1.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				pro1.setFechaFinReal(rs.getDate("fecha_fin_real"));
				pro1.setVentaPrevisto(rs.getDouble("venta_previsto"));
				pro1.setCostesPrevisto(rs.getDouble("costes_previsto"));
				pro1.setCosteReal(rs.getDouble("coste_real"));
				pro1.setEstado(rs.getString("estado"));
				pro1.setJefeProyecto(empimpl1.buscarUno(rs.getInt("jefe_proyecto")));
				pro1.setCif(cliimpl1.buscarUno(rs.getString("cif")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro1;
	}
	
	public List<Proyecto> proyectosByEstado(String estado) {
		sql = "select * from proyectos where estado = ?";
		List<Proyecto> lista = new ArrayList<>();
	    ClienteImplMySql cliimpl1 = new ClienteImplMySql();
	    EmpleadoImplMySql empimpl1 = new EmpleadoImplMySql();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, estado);
			rs = ps.executeQuery();
			while (rs.next()) {
			    Proyecto pro1 = new Proyecto();
			    pro1.setIdProyecto(rs.getString("id_proyecto"));
			    pro1.setDescripcion(rs.getString("descripcion"));
			    pro1.setFechaInicio(rs.getDate("fecha_inicio"));
			    pro1.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
			    pro1.setFechaFinReal(rs.getDate("fecha_fin_real"));
			    pro1.setVentaPrevisto(rs.getDouble("venta_previsto"));
			    pro1.setCostesPrevisto(rs.getDouble("costes_previsto"));
			    pro1.setCosteReal(rs.getDouble("coste_real"));
			    pro1.setEstado(rs.getString("estado"));
			    pro1.setJefeProyecto(empimpl1.buscarUno(rs.getInt("jefe_proyecto")));   
			    pro1.setCif(cliimpl1.buscarUno(rs.getString("cif")));   
			    lista.add(pro1);	    
			}
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return lista;
	}
	
	public List<Proyecto> proyectosByCliente(String cif) {
		sql = "select * from proyectos where cif = ?";
		List<Proyecto> lista = new ArrayList<>();
	    ClienteImplMySql cliimpl1 = new ClienteImplMySql();
	    EmpleadoImplMySql empimpl1 = new EmpleadoImplMySql();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, cif);
			rs = ps.executeQuery();
			while (rs.next()) {
			    Proyecto pro1 = new Proyecto();
			    pro1.setIdProyecto(rs.getString("id_proyecto"));
			    pro1.setDescripcion(rs.getString("descripcion"));
			    pro1.setFechaInicio(rs.getDate("fecha_inicio"));
			    pro1.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
			    pro1.setFechaFinReal(rs.getDate("fecha_fin_real"));
			    pro1.setVentaPrevisto(rs.getDouble("venta_previsto"));
			    pro1.setCostesPrevisto(rs.getDouble("costes_previsto"));
			    pro1.setCosteReal(rs.getDouble("coste_real"));
			    pro1.setEstado(rs.getString("estado"));
			    pro1.setJefeProyecto(empimpl1.buscarUno(rs.getInt("jefe_proyecto")));   
			    pro1.setCif(cliimpl1.buscarUno(rs.getString("cif")));   
			    lista.add(pro1);	    
			}
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return lista;
	}
	
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		sql = "select * from proyectos where jefe_proyecto = ? and estado = ? ";
		List<Proyecto> lista = new ArrayList<>();
	    ClienteImplMySql cliimpl1 = new ClienteImplMySql();
	    EmpleadoImplMySql empimpl1 = new EmpleadoImplMySql();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, jefeProyecto);
			ps.setString(2, estado);
			rs = ps.executeQuery();
			while (rs.next()) {
			    Proyecto pro1 = new Proyecto();
			    pro1.setIdProyecto(rs.getString("id_proyecto"));
			    pro1.setDescripcion(rs.getString("descripcion"));
			    pro1.setFechaInicio(rs.getDate("fecha_inicio"));
			    pro1.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
			    pro1.setFechaFinReal(rs.getDate("fecha_fin_real"));
			    pro1.setVentaPrevisto(rs.getDouble("venta_previsto"));
			    pro1.setCostesPrevisto(rs.getDouble("costes_previsto"));
			    pro1.setCosteReal(rs.getDouble("coste_real"));
			    pro1.setEstado(rs.getString("estado"));
			    pro1.setJefeProyecto(empimpl1.buscarUno(rs.getInt("jefe_proyecto")));   
			    pro1.setCif(cliimpl1.buscarUno(rs.getString("cif")));   
			    lista.add(pro1);	    
			}
		} catch (SQLException e) {
            e.printStackTrace();
        }
		return lista;
	}
	
    public double importeVentaProyectosTerminados() {
        sql = "select sum(venta_previsto) from proyectos where estado = ?";
        double suma = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "terminado");
            rs = ps.executeQuery();
            if (rs.next())
                suma = rs.getDouble(1);	    	
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return suma;
    }	
	
    public double margenBrutoProyectosTerminados() {
        sql = "select sum(venta_previsto)-sum(coste_real) from proyectos where estado = ?";
        double suma = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "terminado");
            rs = ps.executeQuery();
            if (rs.next())
                suma = rs.getDouble(1);	    	
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return suma;
    }	
    
    public int diasATerminoProyectoActivo(String idProyecto) {
		sql = "select datediff(fecha_fin_previsto, current_date()) from proyectos where id_proyecto = ?";
		int diferencia=0;
        try {
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, idProyecto);
	        rs = ps.executeQuery();
	        if (rs.next())
	        	diferencia = rs.getInt(1);	 
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	    return diferencia;
	}

    public int diferenciaFinPrevistoReal(String idProyecto) {
		sql = "select datediff(fecha_fin_previsto, fecha_fin_real) from proyectos where id_proyecto = ?";
        int diferencia=0;
        try {
            ps = conn.prepareStatement(sql);
    		ps.setString(1, idProyecto);
            rs = ps.executeQuery();
            if (rs.next())
                diferencia = rs.getInt(1);	 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return diferencia;
    }
	
    /*public List<Integer> diferenciaFinPrevistoReal() {
		sql = "select datediff(fecha_fin_previsto, fecha_fin_real) from proyectos";
		List<Integer> lista = new ArrayList<>();
        int diferencia=0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                diferencia = rs.getInt(1);	 
				lista.add(diferencia);
			}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return lista;
    }*/

    //Devuelve un list donde cada elemento es a su vez un arraylist que contiene el idProyecto y la diferencia
    public List<ArrayList> diferenciaFinPrevistoReal2() {
		sql = "select id_proyecto, datediff(fecha_fin_previsto, fecha_fin_real) from proyectos";
		List<ArrayList> lista = new ArrayList<>();
        int diferencia=0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                diferencia = rs.getInt(2);	 
                ArrayList<Object> lista1=new ArrayList<>(Arrays.asList(rs.getString("id_proyecto"),diferencia));
                		lista.add(lista1);
			}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return lista;
    }

}
