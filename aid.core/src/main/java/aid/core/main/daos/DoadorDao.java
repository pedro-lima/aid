package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalDoadorDao;
import aid.core.main.models.Doador;

@Dao
public class DoadorDao extends AbstractDao<Doador> implements LocalDoadorDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Doador.class;
	}

}
