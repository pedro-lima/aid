package aid.core.main.interfaces.search;

import java.io.Serializable;
import java.util.List;

import aid.core.main.enumerations.Ordenacao;
import aid.core.main.enumerations.TipoSoftware;
import aid.core.main.tos.SoftwareTO;

public interface LazySoftwareSearchBusiness extends Serializable {

	public List<SoftwareTO> pesquisar(String marca, String modelo,
			String observacao, TipoSoftware tipo, Ordenacao ordenacao,
			String campoOrdenacao, int first, int maxResults);

	public long total(String marca, String modelo, String observacao,
			TipoSoftware tipo);

}
