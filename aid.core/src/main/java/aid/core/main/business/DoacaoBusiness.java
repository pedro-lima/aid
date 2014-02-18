package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalDoacaoBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalDoacaoDao;
import aid.core.main.models.Doacao;

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
