package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalProfessorDao;
import br.com.aid.core.models.Professor;

@Dao
public class ProfessorDao extends AbstractDao<Professor> implements
		LocalProfessorDao {
	
	private static final long serialVersionUID = 5950195870183156401L;

	public ProfessorDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Professor.class;
	}

}
