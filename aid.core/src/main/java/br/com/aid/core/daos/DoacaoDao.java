package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalDoacaoDao;
import br.com.aid.core.models.Doacao;

@Dao
public class DoacaoDao extends AbstractDao<Doacao> implements LocalDoacaoDao {
	
	private static final long serialVersionUID = 5839598625598197803L;

	public DoacaoDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Doacao.class;
	}

}
