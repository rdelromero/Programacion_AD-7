package modelo.daojdbc;
import java.sql.SQLException;
import java.util.List; import java.util.ArrayList;
import modelo.javabean.Empleado;

public class EmpleadoImplMySql extends AbstractMySql implements EmpleadoDao {

	//Métodos DML-select--------------------------------------------------------------------------------------
    public List<Empleado> buscarTodos() {
	    List<Empleado> lista = new ArrayList<>();
	    PerfilImplMySql perfilimpl1 = new PerfilImplMySql();
	    DepartamentoImplMySql dptoimpl1 = new DepartamentoImplMySql();
	    try {
	    	ps = conn.prepareStatement("select * from empleados");
	    	rs = ps.executeQuery();
	    	while (rs.next()) {
	    		Empleado emp1 = new Empleado();
			    emp1.setIdEmpl(rs.getInt("id_empl"));
			    emp1.setNombre(rs.getString("nombre"));
			    emp1.setApellidos(rs.getString("apellidos"));
		        String cadena=rs.getString("sexo");
			    emp1.setSexo(cadena.charAt(0));
			    emp1.setEmail(rs.getString("email"));
			    emp1.setPassword(rs.getString("password"));
			    emp1.setSalario(rs.getDouble("salario"));
			    emp1.setFechaIngreso(rs.getDate("fecha_ingreso"));
			    emp1.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
		        emp1.setPerfil(perfilimpl1.buscarUno(rs.getInt("id_perfil")));   
		        emp1.setDepartamento(dptoimpl1.buscarUno(rs.getInt("id_depar")));
		        lista.add(emp1);
	    	}   
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    return lista;
    }
	
	public Empleado buscarUno(int idEmpl) {
		Empleado emp1 = null;
		try {
			ps = conn.prepareStatement("select * from empleados where id_empl = ?");
			ps.setInt(1, idEmpl);
			rs = ps.executeQuery();
			if (rs.next()) {
				emp1 = new Empleado();
				PerfilImplMySql perfilimpl1 = new PerfilImplMySql();
				DepartamentoImplMySql dptoimpl1 = new DepartamentoImplMySql();
				emp1.setIdEmpl(rs.getInt("id_empl"));
				emp1.setNombre(rs.getString("nombre"));
				emp1.setApellidos(rs.getString("apellidos"));
			    String cadena=rs.getString("sexo");
				emp1.setSexo(cadena.charAt(0));
				emp1.setEmail(rs.getString("email"));
				emp1.setPassword(rs.getString("password"));
				emp1.setSalario(rs.getDouble("salario"));
				emp1.setFechaIngreso(rs.getDate("fecha_ingreso"));
				emp1.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
			    emp1.setPerfil(perfilimpl1.buscarUno(rs.getInt("id_perfil")));   
			    emp1.setDepartamento(dptoimpl1.buscarUno(rs.getInt("id_depar")));  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp1;
	}
	
	public List<Empleado> empleadosByApellido(String apellido) {
		List<Empleado> lista = new ArrayList<>();
		PerfilImplMySql perfilimpl1 = new PerfilImplMySql();
		DepartamentoImplMySql dptoimpl1 = new DepartamentoImplMySql();
		try {
			ps = conn.prepareStatement("select * from empleados where apellidos = ?");
			ps.setString(1, apellido);
			rs = ps.executeQuery();
			while (rs.next()) {
				Empleado emp1 = new Empleado();
				emp1.setIdEmpl(rs.getInt("id_empl"));
				emp1.setNombre(rs.getString("nombre"));
				emp1.setApellidos(rs.getString("apellidos"));
			    String cadena=rs.getString("sexo");
				emp1.setSexo(cadena.charAt(0));
				emp1.setEmail(rs.getString("email"));
				emp1.setPassword(rs.getString("password"));
				emp1.setSalario(rs.getDouble("salario"));
				emp1.setFechaIngreso(rs.getDate("fecha_ingreso"));
				emp1.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				emp1.setPerfil(perfilimpl1.buscarUno(rs.getInt("id_perfil")));
				emp1.setDepartamento(dptoimpl1.buscarUno(rs.getInt("id_depar")));
				lista.add(emp1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Empleado> empleadosBySexo(char sexo) {
		List<Empleado> lista = new ArrayList<>();
		PerfilImplMySql perfilimpl1 = new PerfilImplMySql();
		DepartamentoImplMySql dptoimpl1 = new DepartamentoImplMySql();
		try {
			ps = conn.prepareStatement("select * from empleados where sexo = ?");
			ps.setString(1, String.valueOf(sexo));
			rs = ps.executeQuery();

			while (rs.next()) {
				Empleado emp1 = new Empleado();
				emp1.setIdEmpl(rs.getInt("id_empl"));
				emp1.setNombre(rs.getString("nombre"));
				emp1.setApellidos(rs.getString("apellidos"));
			    String cadena=rs.getString("sexo");
				emp1.setSexo(cadena.charAt(0));
				emp1.setEmail(rs.getString("email"));
				emp1.setPassword(rs.getString("password"));
				emp1.setSalario(rs.getDouble("salario"));
				emp1.setFechaIngreso(rs.getDate("fecha_ingreso"));
				emp1.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				emp1.setPerfil(perfilimpl1.buscarUno(rs.getInt("id_perfil")));
				emp1.setDepartamento(dptoimpl1.buscarUno(rs.getInt("id_depar")));
				lista.add(emp1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		List<Empleado> lista = new ArrayList<>();
		PerfilImplMySql perfilimpl1 = new PerfilImplMySql();
		DepartamentoImplMySql dptoimpl1 = new DepartamentoImplMySql();
		try {
			ps = conn.prepareStatement("select * from empleados where id_depar = ?");
			ps.setInt(1, idDepar);
			rs = ps.executeQuery();
			while (rs.next()) {
				Empleado emp1 = new Empleado();
				emp1.setIdEmpl(rs.getInt("id_empl"));
				emp1.setNombre(rs.getString("nombre"));
				emp1.setApellidos(rs.getString("apellidos"));
			    String cadena=rs.getString("sexo");
				emp1.setSexo(cadena.charAt(0));
				emp1.setEmail(rs.getString("email"));
				emp1.setPassword(rs.getString("password"));
				emp1.setSalario(rs.getDouble("salario"));
				emp1.setFechaIngreso(rs.getDate("fecha_ingreso"));
				emp1.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				emp1.setPerfil(perfilimpl1.buscarUno(rs.getInt("id_perfil")));
				emp1.setDepartamento(dptoimpl1.buscarUno(rs.getInt("id_depar")));
				lista.add(emp1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	//Métodos DML-insert--------------------------------------------------------------------------
	public boolean altaEmpleado(Empleado empleado) {
		try {
			ps = conn.prepareStatement("insert into empleados values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, empleado.getIdEmpl());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellidos());
			ps.setString(4, String.valueOf(empleado.getSexo()));
			ps.setString(5, empleado.getEmail());
			ps.setString(6, empleado.getPassword());
			ps.setDouble(7, empleado.getSalario());
			ps.setDate(8, empleado.getFechaIngreso());
			ps.setDate(9, empleado.getFechaNacimiento());
			ps.setInt(10, empleado.getPerfil().getIdPerfil());
			ps.setInt(11, empleado.getDepartamento().getIdDepar());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Métodos DML-delete------------------------------------------------------------------------------------
	public boolean bajaEmpleado(int idEmpl) {
		try {
			ps = conn.prepareStatement("delete from empleados where id_empl = ?");
			ps.setInt(1, idEmpl);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

    //Métodos DML-update-------------------------------------------------------------------------------------
    public boolean modificarEmpleado(Empleado empleado) {
        try {
			ps = conn.prepareStatement("update empleados set nombre = ?, apellidos = ?, sexo = ?, email = ?, password = ?, salario = ?, fecha_ingreso = ?, fecha_nacimiento = ?, id_perfil = ?, id_depar = ? where id_empl = ?");
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellidos());
			ps.setString(3, String.valueOf(empleado.getSexo()));
			ps.setString(4, empleado.getEmail());
			ps.setString(5, empleado.getPassword());
			ps.setDouble(6, empleado.getSalario());
			ps.setDate(7, empleado.getFechaIngreso());
			ps.setDate(8, empleado.getFechaNacimiento());
			ps.setInt(9, empleado.getPerfil().getIdPerfil());
			ps.setInt(10, empleado.getDepartamento().getIdDepar());
			ps.setInt(11, empleado.getIdEmpl());
			ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
    public double salarioTotal() {
        double suma = 0;
        try {
            ps = conn.prepareStatement("select sum(salario) from empleados");
            rs = ps.executeQuery();
            if (rs.next())
                suma = rs.getDouble(1);	    	
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return suma;
    }	
	
    public double salarioTotal(int idDepar) {
        double suma = 0;
        try {
            ps = conn.prepareStatement("select sum(salario) from empleados where id_depar = ?");
			ps.setDouble(1, idDepar);
            rs = ps.executeQuery();
            if (rs.next())
                suma = rs.getInt(1);	    	
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return suma;
    }	
    
}

