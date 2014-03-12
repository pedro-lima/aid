package br.com.aid.admin.interfaces;

import br.com.aid.core.enumerations.TipoSoftware;
import br.com.aid.core.tos.SoftwareTO;

public interface LazySoftwareCollection extends LazyCollection<SoftwareTO> {

	public void setParametrosPesquisa(String marca, String modelo,
			String observacao, TipoSoftware tipo);	

}
