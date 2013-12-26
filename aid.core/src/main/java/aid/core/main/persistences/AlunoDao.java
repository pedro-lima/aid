package aid.core.main.persistences;

import aid.core.main.models.Aluno;

public class AlunoDao extends AbstractDao<Aluno> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {		
		return Aluno.class;
	}

}
