package aid.core.main.business;

import aid.core.main.interfaces.business.LocalItemHomologacaoBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalItemHomologacaoDao;
import aid.core.main.models.ItemHomologacao;

public class ItemHomologacaoBusiness extends AbstracBusiness<ItemHomologacao>
		implements LocalItemHomologacaoBusiness {
	private static final long serialVersionUID = -6780493840302830137L;
	private LocalItemHomologacaoDao dao;

	public ItemHomologacaoBusiness() {
		super();
	}

	@Override
	protected Dao<ItemHomologacao> getDao() {
		return this.dao;
	}

}
