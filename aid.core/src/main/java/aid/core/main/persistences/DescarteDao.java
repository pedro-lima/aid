package aid.core.main.persistences;

import aid.core.main.models.Descarte;

public class DescarteDao extends AbstractDao<Descarte> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Descarte.class;
	}

}
