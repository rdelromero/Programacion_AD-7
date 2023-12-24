package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {
	public static Connection conn;
	
	public ConexionMySql() {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes_proyectos_empleados_2023?serverTimezone=UTC", "root", "melasola");
			System.out.println("Conexión establecida.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error en la conexión.");
		}
	}
	
	public static Connection getConexion() {
		if (conn==null) {
			new ConexionMySql();
		}
		return conn;
	}

}

