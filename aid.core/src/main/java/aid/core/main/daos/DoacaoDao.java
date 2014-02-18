package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalDoacaoDao;
import aid.core.main.models.Doacao;

@Dao
public class DoacaoDao extends AbstractDao<Doacao> implements LocalDoacaoDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Doacao.class;
	}

}
