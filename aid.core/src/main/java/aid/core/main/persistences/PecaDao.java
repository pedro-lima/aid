package aid.core.main.persistences;

import aid.core.main.models.Peca;

public class PecaDao extends AbstractDao<Peca> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Peca.class;
	}

}
