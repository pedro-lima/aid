package aid.core.main.interfaces.business;

import java.io.Serializable;
import aid.core.main.exceptions.CRUDException;

public interface Business<T> extends Serializable {

	public void salvar(T obj) throws CRUDException;

	public void remover(T obj) throws CRUDException;

	public T buscar(Long id) throws CRUDException;
}
