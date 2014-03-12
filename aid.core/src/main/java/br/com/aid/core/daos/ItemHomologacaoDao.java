package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalItemHomologacaoDao;
import br.com.aid.core.models.ItemHomologacao;

@Dao
public class ItemHomologacaoDao extends AbstractDao<ItemHomologacao> implements
		LocalItemHomologacaoDao {

	private static final long serialVersionUID = 4450407543492291395L;

	public ItemHomologacaoDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return ItemHomologacao.class;
	}

}
