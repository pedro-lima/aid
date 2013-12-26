package aid.core.main.persistences;

import aid.core.main.models.Ponto;

public class PontoDao extends AbstractDao<Ponto> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Ponto.class;
	}

}
