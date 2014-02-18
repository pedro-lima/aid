package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalItemHomologacaoDao;
import aid.core.main.models.ItemHomologacao;

@Dao
public class ItemHomologacaoDao extends AbstractDao<ItemHomologacao> implements
		LocalItemHomologacaoDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return ItemHomologacao.class;
	}

}
