package modelo.daojdbc;
import java.sql.SQLException;
import java.util.List; import java.util.ArrayList;
import modelo.javabean.Cliente;

public class ClienteImplMySql extends AbstractMySql implements ClienteDao {
	
	//Métodos DML-select--------------------------------------------------------------
	
	public List<Cliente> buscarTodos() {
		List<Cliente> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement("select * from clientes");
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
		Cliente cli1 = null;
		try {
			ps = conn.prepareStatement("select * from clientes where cif = ?");
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
	public boolean altaCliente(Cliente cliente) {
		try {
			ps = conn.prepareStatement("insert into clientes values(?,?,?,?,?,?)");
			ps.setString(1, cliente.getCif());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getDomicilio());
			ps.setDouble(5, cliente.getFacturacionAnual());
			ps.setInt(6, cliente.getNumeroEmpleados());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	//Métodos DML-update--------------------------------------------------------------------
    public boolean modificarCliente(Cliente cliente) {
        try {
			ps = conn.prepareStatement("update empleados set cif = ?, nombre = ?, apellidos = ?, domicilio = ?, facturacion_anual = ?, numero_empleados = ? where cif = ?");
			ps.setString(1, cliente.getCif());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getApellidos());
			ps.setDouble(5, cliente.getFacturacionAnual());
			ps.setInt(6, cliente.getNumeroEmpleados());
			ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	//Métodos DML-delete-------------------------------------------------------------------
	public boolean bajaCliente(String cif) {
		try {
			ps = conn.prepareStatement("delete from clientes where cif = ?");
			ps.setString(1, cif);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
