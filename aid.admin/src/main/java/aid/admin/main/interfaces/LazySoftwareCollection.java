package aid.admin.main.interfaces;

import java.util.List;

import aid.core.main.enumerations.TipoSoftware;
import aid.core.main.tos.SoftwareTO;

public interface LazySoftwareCollection extends LazyCollection<SoftwareTO> {

	public void setParametrosPesquisa(String marca, String modelo,
			String observacao, TipoSoftware tipo);

	public List<SoftwareTO> pesquisar();

}
