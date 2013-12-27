package aid.core.main.interfaces;

import java.util.List;

public interface Dao<T> {
	
	public void salvar(T obj);

	public void remover(T obj);

	public void atualizar(T obj);	

	public List<T> listar();
	
	public List<T> listar(String query);
	
	public List<T> list(int offset, int max);

	public T buscar(Long id);
	
	public T buscar(String query);
	
	public Long count();

}