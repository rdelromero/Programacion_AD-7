package modelo.daojdbc;
import java.sql.SQLException;
import java.util.List; import java.util.ArrayList; 
import modelo.javabean.Departamento;

public class DepartamentoImplMySql extends AbstractMySql implements DepartamentoDao {
	
	//Métodos DML-select-----------------------------------------------------------------------
	public List<Departamento> buscarTodos() {
		List<Departamento> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement("select * from departamentos");
			rs = ps.executeQuery();
			while (rs.next()) {
				Departamento dpto1 = new Departamento();
				dpto1.setIdDepar(rs.getInt("id_depar"));
				dpto1.setNombre(rs.getString("nombre"));
				dpto1.setDireccion(rs.getString("direccion"));
				lista.add(dpto1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Departamento buscarUno(int idDepar) {
		Departamento dpto1 = null;
		try {
			ps = conn.prepareStatement("select * from departamentos where id_depar = ?");
			ps.setInt(1, idDepar);
			rs = ps.executeQuery();
			if (rs.next()) {
				dpto1 = new Departamento();
				dpto1.setIdDepar(rs.getInt("id_depar"));
				dpto1.setNombre(rs.getString("nombre"));
				dpto1.setDireccion(rs.getString("direccion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dpto1;
	}
	
}
