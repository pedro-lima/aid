package br.com.aid.core.interfaces.dao;

import java.util.List;

import br.com.aid.core.enumerations.Ordenacao;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Doador;
import br.com.aid.core.models.Estado;
import br.com.aid.core.tos.DoadorTO;

public interface LocalDoadorDao extends Dao<Doador> {

	public List<DoadorTO> pesquisar(String nome, String email, Cidade cidade,
			Estado estado, Ordenacao ordenacao, String campoOrdenacao,
			int first, int maxResults);

	public long total(String nome, String email, Cidade cidade, Estado estado);

}
