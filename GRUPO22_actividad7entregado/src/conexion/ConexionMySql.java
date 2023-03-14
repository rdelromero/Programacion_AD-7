package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {
	public static String url,username,password;
	public static Connection conn;
	
	public ConexionMySql() {
		url="jdbc:mysql://localhost:3306/clientes_proyectos_empleados_2023?serverTimezone=UTC";
		username="root"; password="melasola";
		try {
			conn=DriverManager.getConnection(url, username, password);
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