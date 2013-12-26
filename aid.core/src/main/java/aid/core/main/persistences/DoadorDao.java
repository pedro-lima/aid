package aid.core.main.persistences;

import aid.core.main.models.Doador;

public class DoadorDao extends AbstractDao<Doador> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Doador.class;
	}

}
