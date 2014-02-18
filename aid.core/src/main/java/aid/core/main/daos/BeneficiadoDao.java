package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalBeneficiadoDao;
import aid.core.main.models.Beneficiado;

@Dao
public class BeneficiadoDao extends AbstractDao<Beneficiado> implements
		LocalBeneficiadoDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Beneficiado.class;
	}

}
