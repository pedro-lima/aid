package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalPontoDao;
import br.com.aid.core.models.Ponto;

@Dao
public class PontoDao extends AbstractDao<Ponto> implements LocalPontoDao {

	private static final long serialVersionUID = 1311776393656722805L;

	public PontoDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Ponto.class;
	}

}
