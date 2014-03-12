package br.com.aid.core.interfaces.search;

import java.io.Serializable;
import java.util.List;

import br.com.aid.core.enumerations.Ordenacao;
import br.com.aid.core.enumerations.TipoSoftware;
import br.com.aid.core.tos.SoftwareTO;

public interface LazySoftwareSearchBusiness extends Serializable {

	public List<SoftwareTO> pesquisar(String marca, String modelo,
			String observacao, TipoSoftware tipo, Ordenacao ordenacao,
			String campoOrdenacao, int first, int maxResults);

	public long total(String marca, String modelo, String observacao,
			TipoSoftware tipo);

}
