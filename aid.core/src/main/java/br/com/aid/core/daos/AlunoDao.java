package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalAlunoDao;
import br.com.aid.core.models.Aluno;

@Dao
public class AlunoDao extends AbstractDao<Aluno> implements LocalAlunoDao {
		
	private static final long serialVersionUID = -5963140683168913824L;
		
	public AlunoDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Aluno.class;
	}

}
