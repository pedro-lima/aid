package aid.core.main.interfaces;

import java.io.Serializable;
import java.util.List;
import aid.core.main.pojos.QueryParam;

public interface Dao<T> extends Serializable {	
	
	public void salvar(T obj);
	
	public void remover(T obj);
	
	public T atualizar(T obj);
	
	public T buscar(Long id);
	
	public List<T> listar();
	
	public T buscar(String query, QueryParam... params);
	
	public List<T> listar(String query, QueryParam... params);
	
	public List<T> listar(String query, int offset, int max, QueryParam... params);
	
	public int executar(String query, QueryParam... params);

	public Long count(String query, QueryParam... params);

}