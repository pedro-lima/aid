package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalDescarteDao;
import aid.core.main.models.Descarte;

@Dao
public class DescarteDao extends AbstractDao<Descarte> implements
		LocalDescarteDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Descarte.class;
	}

}
