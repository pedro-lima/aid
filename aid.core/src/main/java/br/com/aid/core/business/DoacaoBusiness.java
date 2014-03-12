package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalDoacaoBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalDoacaoDao;
import br.com.aid.core.models.Doacao;

@Business
public class DoacaoBusiness extends AbstracBusiness<Doacao> implements
		LocalDoacaoBusiness {
	
	private static final long serialVersionUID = 807834398370705713L;
	
	@Inject
	private LocalDoacaoDao dao;

	public DoacaoBusiness() {
		super();
	}

	@Override
	protected Dao<Doacao> getDao() {
		return this.dao;
	}
}
