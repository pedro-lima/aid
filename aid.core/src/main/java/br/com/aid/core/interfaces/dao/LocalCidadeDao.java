package br.com.aid.core.interfaces.dao;

import java.util.List;

import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;

public interface LocalCidadeDao extends Dao<Cidade> {
	
	public List<Cidade> listar(Estado estado);

}
