package aid.core.main.persistences;

import aid.core.main.models.Montagem;

public class MontagemDao extends AbstractDao<Montagem> {
private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Montagem.class;
	}

}
