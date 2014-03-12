package br.com.aid.admin.interfaces;

import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;
import br.com.aid.core.tos.BeneficiadoTO;

public interface LazyBeneficiadoCollection extends
		LazyCollection<BeneficiadoTO> {

	public void setParametrosPesquisa(String nome, String rua, String numero,
			String bairro, String cep, Cidade cidade, Estado estado);

}
