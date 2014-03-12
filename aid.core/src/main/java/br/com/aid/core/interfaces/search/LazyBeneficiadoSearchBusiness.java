package br.com.aid.core.interfaces.search;

import java.io.Serializable;
import java.util.List;

import br.com.aid.core.enumerations.Ordenacao;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;
import br.com.aid.core.tos.BeneficiadoTO;

public interface LazyBeneficiadoSearchBusiness extends Serializable {

	public List<BeneficiadoTO> pesquisar(String nome, String rua, String numero,
			String bairro, String cep, Cidade cidade, Estado estado,
			Ordenacao ordenacao, String campoOrdenacao, int first,
			int maxResults);

	public long total(String nome, String rua, String numero, String bairro,
			String cep, Cidade cidade, Estado estado);
}
