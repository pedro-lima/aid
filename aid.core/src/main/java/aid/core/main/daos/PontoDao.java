package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalPontoDao;
import aid.core.main.models.Ponto;

@Dao
public class PontoDao extends AbstractDao<Ponto> implements LocalPontoDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Ponto.class;
	}

}
