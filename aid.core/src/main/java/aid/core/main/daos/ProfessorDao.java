package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalProfessorDao;
import aid.core.main.models.Professor;

@Dao
public class ProfessorDao extends AbstractDao<Professor> implements
		LocalProfessorDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Professor.class;
	}

}
