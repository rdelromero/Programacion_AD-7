package modelo.daojdbc;
import java.util.List;
import modelo.javabean.Cliente;
public interface ClienteDao {
    public abstract List<Cliente> buscarTodos();
    public abstract Cliente buscarUno(String cif);
    public abstract boolean altaCliente(Cliente cliente);
    public abstract boolean modificarCliente(Cliente cliente);
    public abstract boolean bajaCliente(String cif);
}
