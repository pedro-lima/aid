package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalPecaDao;
import aid.core.main.models.Peca;

@Dao
public class PecaDao extends AbstractDao<Peca> implements LocalPecaDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Peca.class;
	}

}
