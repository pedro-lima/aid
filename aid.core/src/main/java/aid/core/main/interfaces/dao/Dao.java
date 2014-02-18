package aid.core.main.interfaces.dao;

import java.io.Serializable;

public interface Dao<T> extends Serializable {	
	
	public void salvar(T obj);
	
	public void remover(T obj);
	
	public T atualizar(T obj);
	
	public T buscar(Long id);	
	
}