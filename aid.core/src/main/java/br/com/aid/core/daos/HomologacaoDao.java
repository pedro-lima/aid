package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalHomologacaoDao;
import br.com.aid.core.models.Homologacao;

@Dao
public class HomologacaoDao extends AbstractDao<Homologacao> implements
		LocalHomologacaoDao {

	private static final long serialVersionUID = -7658419879263426326L;

	public HomologacaoDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Homologacao.class;
	}

}
