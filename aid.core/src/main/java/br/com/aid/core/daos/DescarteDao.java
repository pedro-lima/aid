package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalDescarteDao;
import br.com.aid.core.models.Descarte;

@Dao
public class DescarteDao extends AbstractDao<Descarte> implements
		LocalDescarteDao {
	
	private static final long serialVersionUID = 8815230909385753512L;

	public DescarteDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Descarte.class;
	}

}
