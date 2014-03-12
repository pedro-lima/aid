package br.com.aid.core.interfaces.business;

import java.util.List;

import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;

public interface LocalCidadeBusiness extends Business<Cidade>{
	
	public List<Cidade> listar(Estado estado);

}
