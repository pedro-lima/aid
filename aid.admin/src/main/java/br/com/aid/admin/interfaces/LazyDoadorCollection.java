package br.com.aid.admin.interfaces;

import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;

public interface LazyDoadorCollection {

	public void setParametrosPesquisa(String nome, String email, Cidade cidade,
			Estado estado);
}
