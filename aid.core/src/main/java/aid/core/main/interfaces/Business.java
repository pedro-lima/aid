package aid.core.main.interfaces;

import java.io.Serializable;
import java.util.List;

import aid.core.main.exceptions.CRUDException;

public interface Business<T> extends Serializable{

	public abstract void salvar(T obj) throws CRUDException;

	public abstract void remover(T obj) throws CRUDException;

	public abstract void atualizar(T obj) throws CRUDException;

	public abstract List<T> listar();

	public abstract T buscar(Long id);
}
