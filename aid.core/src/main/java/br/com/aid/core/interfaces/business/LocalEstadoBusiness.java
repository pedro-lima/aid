package br.com.aid.core.interfaces.business;

import java.util.List;

import br.com.aid.core.models.Estado;

public interface LocalEstadoBusiness extends Business<Estado> {
	
	public List<Estado> listar();

}
