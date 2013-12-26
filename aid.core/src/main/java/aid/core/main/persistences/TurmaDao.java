package aid.core.main.persistences;

import aid.core.main.models.Turma;

@SuppressWarnings("serial")
public class TurmaDao extends AbstractDao<Turma> {

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Turma.class;
	}

}
