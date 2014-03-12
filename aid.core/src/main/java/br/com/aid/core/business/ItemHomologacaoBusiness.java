package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalItemHomologacaoBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalItemHomologacaoDao;
import br.com.aid.core.models.ItemHomologacao;

@Business
public class ItemHomologacaoBusiness extends AbstracBusiness<ItemHomologacao>
		implements LocalItemHomologacaoBusiness {
	
	private static final long serialVersionUID = -6780493840302830137L;
	
	@Inject
	private LocalItemHomologacaoDao dao;

	public ItemHomologacaoBusiness() {
		super();
	}

	@Override
	protected Dao<ItemHomologacao> getDao() {
		return this.dao;
	}

}
