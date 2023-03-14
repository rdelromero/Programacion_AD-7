package modelo.daojdbc;
import java.sql.SQLException;
import java.util.List; import java.util.ArrayList;
import modelo.javabean.Cliente;

public class ClienteImplMySql extends AbstractMySql implements ClienteDao {
	
	//Métodos DML-select--------------------------------------------------------------
	
	public List<Cliente> buscarTodos() {
		sql = "select * from clientes";
		List<Cliente> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cli1=new Cliente();
				cli1.setCif(rs.getString("cif"));
				cli1.setNombre(rs.getString("nombre"));
				cli1.setApellidos(rs.getString("apellidos"));
				cli1.setDomicilio(rs.getString("domicilio"));
				cli1.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cli1.setNumeroEmpleados(rs.getInt("numero_empleados"));
				lista.add(cli1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Cliente buscarUno(String cif) {
		sql = "select * from clientes where cif = ?";
		Cliente cli1 = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			rs = ps.executeQuery();
			if (rs.next()) {
				cli1 = new Cliente();
				cli1.setCif(rs.getString("cif"));
				cli1.setNombre(rs.getString("nombre"));
				cli1.setApellidos(rs.getString("apellidos"));
				cli1.setDomicilio(rs.getString("domicilio"));
				cli1.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cli1.setNumeroEmpleados(rs.getInt("numero_empleados"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli1;
	}
	
	//Métodos DML-insert----------------------------------------------------------------------
	public int altaCliente(Cliente cliente) {
		sql = "insert into clientes values(?,?,?,?,?,?)";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCif());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getDomicilio());
			ps.setDouble(5, cliente.getFacturacionAnual());
			ps.setInt(6, cliente.getNumeroEmpleados());
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}
	
	//Métodos DML-update--------------------------------------------------------------------
	
    public int modificarCliente(Cliente cliente) {
        sql = "update empleados set cif = ?, nombre = ?, apellidos = ?, domicilio = ?, facturacion_anual = ?, numero_empleados = ? where cif = ?";
        try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCif());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getApellidos());
			ps.setDouble(5, cliente.getFacturacionAnual());
			ps.setInt(6, cliente.getNumeroEmpleados());
			filas = ps.executeUpdate();
            filas = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }
	
	//Métodos DML-delete-------------------------------------------------------------------
	public int bajaCliente(String cif) {
		sql= "delete from clientes where cif = ?";
		filas =0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}
	
}
