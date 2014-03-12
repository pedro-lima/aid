package br.com.aid.core.interfaces.business;

import java.io.Serializable;

public interface Business<T> extends Serializable {

	public void salvar(T obj);

	public void remover(T obj);

	public T buscar(Long id);	
	
}
