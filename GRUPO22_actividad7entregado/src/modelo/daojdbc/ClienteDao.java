package modelo.daojdbc;

import java.util.List;

import modelo.javabean.Cliente;

public interface ClienteDao {
    public abstract List<Cliente> buscarTodos();
    public abstract Cliente buscarUno(String cif);
    public abstract int altaCliente(Cliente cliente);
    public abstract int modificarCliente(Cliente cliente);
    public abstract int bajaCliente(String cif);
}
