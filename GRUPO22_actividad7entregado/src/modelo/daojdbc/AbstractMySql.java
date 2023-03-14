package modelo.daojdbc;
import conexion.ConexionMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractMySql {
	
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	protected int filas;
	
	public AbstractMySql() {
		conn = ConexionMySql.getConexion();
	}
}
