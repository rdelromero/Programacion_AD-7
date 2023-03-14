package modelo.daojdbc;

import java.util.List;

import modelo.javabean.Departamento;

public interface DepartamentoDao {
    public abstract List<Departamento> buscarTodos();
    public abstract Departamento buscarUno(int idDepar);
    
}
