package br.com.aid.core.interfaces.dao;

import java.util.List;

import br.com.aid.core.models.Estado;

public interface LocalEstadoDao extends Dao<Estado> {
	
	public List<Estado> listar();

}
