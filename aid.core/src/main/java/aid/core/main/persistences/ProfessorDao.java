package aid.core.main.persistences;

import aid.core.main.models.Professor;

public class ProfessorDao extends AbstractDao<Professor> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Professor.class;
	}

}
