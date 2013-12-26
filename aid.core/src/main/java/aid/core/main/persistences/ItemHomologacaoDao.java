package aid.core.main.persistences;

import aid.core.main.models.ItemHomologacao;

public class ItemHomologacaoDao extends AbstractDao<ItemHomologacao> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return ItemHomologacao.class;
	}

}
