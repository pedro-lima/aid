package aid.core.main.persistences;

import aid.core.main.models.Beneficiado;

public class BeneficiadoDao extends AbstractDao<Beneficiado> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Beneficiado.class;
	}

}
