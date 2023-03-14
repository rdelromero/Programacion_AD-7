package modelo.daojdbc;
import java.sql.SQLException;
import modelo.javabean.Perfil;

public class PerfilImplMySql extends AbstractMySql implements PerfilDao{
	
	//Métodos DML-select-----------------------------------------------------------------------
	public Perfil buscarUno(int idPerfil) {
		sql = "select * from perfiles where id_perfil = ?";
		Perfil perfil1 = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idPerfil);
			rs = ps.executeQuery();
			if (rs.next()) {
				perfil1 = new Perfil();
				perfil1.setIdPerfil(rs.getInt("id_perfil"));
				perfil1.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return perfil1;
	}
}
