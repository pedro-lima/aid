package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalMontagemDao;
import aid.core.main.models.Montagem;

@Dao
public class MontagemDao extends AbstractDao<Montagem> implements
		LocalMontagemDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Montagem.class;
	}

}
