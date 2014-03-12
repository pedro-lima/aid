package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalPecaDao;
import br.com.aid.core.models.Peca;

@Dao
public class PecaDao extends AbstractDao<Peca> implements LocalPecaDao {

	private static final long serialVersionUID = -3574312623092138985L;

	public PecaDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Peca.class;
	}

}
