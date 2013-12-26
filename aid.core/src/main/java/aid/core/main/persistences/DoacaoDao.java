package aid.core.main.persistences;

import aid.core.main.models.Doacao;

public class DoacaoDao extends AbstractDao<Doacao> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Doacao.class;
	}

}
