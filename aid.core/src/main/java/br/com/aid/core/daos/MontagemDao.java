package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalMontagemDao;
import br.com.aid.core.models.Montagem;

@Dao
public class MontagemDao extends AbstractDao<Montagem> implements
		LocalMontagemDao {

	private static final long serialVersionUID = -4381029765707328885L;

	public MontagemDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Montagem.class;
	}

}
