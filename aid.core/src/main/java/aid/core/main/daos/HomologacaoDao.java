package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalHomologacaoDao;
import aid.core.main.models.Homologacao;

@Dao
public class HomologacaoDao extends AbstractDao<Homologacao> implements
		LocalHomologacaoDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Homologacao.class;
	}

}
