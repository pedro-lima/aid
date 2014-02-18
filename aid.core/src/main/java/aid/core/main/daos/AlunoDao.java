package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalAlunoDao;
import aid.core.main.models.Aluno;

@Dao
public class AlunoDao extends AbstractDao<Aluno> implements LocalAlunoDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Aluno.class;
	}

}
