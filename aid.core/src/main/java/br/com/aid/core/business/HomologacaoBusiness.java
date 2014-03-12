package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalHomologacaoBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalHomologacaoDao;
import br.com.aid.core.models.Homologacao;

@Business
public class HomologacaoBusiness extends AbstracBusiness<Homologacao> implements
		LocalHomologacaoBusiness {
	
	private static final long serialVersionUID = -4406735515592464020L;
	
	@Inject
	private LocalHomologacaoDao dao;

	public HomologacaoBusiness() {
		super();
	}

	@Override
	protected Dao<Homologacao> getDao() {
		return this.dao;
	}

}
