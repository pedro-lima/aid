package aid.core.main.persistences;

import aid.core.main.models.Homologacao;

public class HomologacaoDao extends AbstractDao<Homologacao> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Homologacao.class;
	}

}
